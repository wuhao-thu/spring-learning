package my.test.spring.transaction.service;

import java.util.List;

public interface Cashier {

    //一次购买多本书，调用BookStoreService的purchase方法
    public void checkout(String username, List<String> isbns);
}
