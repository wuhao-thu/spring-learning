package my.test.spring.hibernate.dao;

public interface BookStoreDao {
    //在数据表 book 中查询，根据书号获取书的单价
    public Double getBookPriceByISBN(String isbn);

    //在数据表 book 中查询，根据书号获取书的名称
    public String getBookNameByISBN(String isbn);

    //在数据表 book_stock 中更新书的库存，使库存-1
    public void updateBookStock(String isbn);

    //从数据表 book_stock 中获取书的库存
    public Integer getBookStock(String isbn);

    //在数据表 account 中更新用户的账户余额，减去当前书的价格
    public void updateUserAccount(String username, Double price);

    //从数据表 account 中获取用户的账户余额
    public Double getUserBalance(String username);
}
