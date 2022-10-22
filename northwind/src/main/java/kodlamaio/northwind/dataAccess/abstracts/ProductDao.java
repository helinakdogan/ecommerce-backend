package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

//CRUD
public interface ProductDao extends JpaRepository<Product,Integer>{
	
	Product getByProductName(String productName);
	
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	
	List<Product> getByCategoryIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	//JPQL 
	//select yerine direkt from dedik -> hepsini atar
	@Query("From Product where productName=:productName and category.categoryId=:categoryId") 
	List<Product> getByNameAndCategory(String productName, int categoryId);

	//JPQL - join işlemi
	// 1. Category'deki ilişkilendirilmiş productları(From'dan sonra yazılanları) -> kodlamaio.northwind.entities.dtos.ProductWithCategoryDto'daki alanlara atar
	// 2. Product ve Category'de join columnlarını belirlemiştik (p ve c onlara verdiğimiz alias yani takma ad)
	// 3. ortada aktarmak istediğimiz alanları yazdık
	@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto" + "(p.id, p.productName, c.categoryName)" + "From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();	
	
}










//ilk query'nin SQL hali
//select * from products where products_name = abc and category_id=1
// : -> parameter ve database Productmış gibi
//select * from products where category_id in(1,2,3,4)


//ikinci query'nin SQL hali (veri tabanında yazılsaydı veri tabanındaki tabloların ismiyle yazılırdı)
//select p.product_id, p.product_name, c.categoryName from categories c inner join products p
//on c.category_id = p.category_id











