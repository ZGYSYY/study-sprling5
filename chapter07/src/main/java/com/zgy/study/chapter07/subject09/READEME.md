## 7.9 注解方法或字段

建议将 JPA 注解注解到字段上而不是 getter 方法上，这样更利于代码的阅读。

**注意**：注解实体并没有要求一定要为属性提供对应的 getter 和 setter 方法，这在 @Version 注解上得到了很好的利用，
通常 version 这个字段是不允许手动修改的，应该交给 Hibernate 来设置和修改，所以 version 字段一般都
不用提供 getter 和 setter 方法。当提供了 setter 方法，我们可以在其中对字段进行额外的处理，比如对数据进行加密或者解密操作。