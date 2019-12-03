# 第七章 在 Spring 中使用 Hibernate

**POJO**：实质上可以理解为简单的实体类，其中有一些属性及其getter setter方法的类,没有业务逻辑。

**ORM库**：对象关系映射库。ORM库的主要目标是缩小关系数据库管理系统(RDBMS）中的关系数据结构与
Java中面向对象（OO）模型之间的差距，以便开发人员可以专注于使用对象模型进行编程，同时轻松执行与持久化相关的操作。

本章将介绍 Spring 中 hibernate 的基本概念和主要用例，特别讨论以下几个主题：
- **配置 Hibernate SessionFactory** : Hibernate的核心概念围绕由 SessionFactory 管理的 Session 接口进行。 我们将演示如何配置Hibernate的会话工厂，以便在Spring应用程序中使用。
- **使用 Hibernate 的ORM的主要概念** ：除了介绍如何使用 Hibernate 将 POJO 映射到底层关系数据库结构的主要概念，还讨论一些常用的关系，包括一对多关系和多对多关系。
- **数据操作** ：举例说明如何在 Spring 环境中使用 Hibernate 执行数据操作（查询、插入、更新、删除）。在使用 Hibernate 时，其 Session 接口是与之交互的主要接口。