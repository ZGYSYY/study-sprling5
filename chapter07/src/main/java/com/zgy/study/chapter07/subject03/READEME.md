## 7.3 使用 Hibernate 注解的 ORM 映射

该 demo 用到了以下知识点：
- Hibernate 的简单映射，使用了 @Entity、@Table、@Id、@GeneratedValue、@Version、@Column、@Temporal 注解。
- Hibernate 的一对多映射，使用了 @OneToMany、@ManyToOne、@JoinColumn 注解。
- Hibernate 的多对多映射，使用了 @ManyToMany、@JoinTable 注解。

**特别注意**：在使用 @OneToMany、@ManyToMany 注解注解的 getter 方法对应属性不应该使用 List 类型，而应该使用 Set 类型，否则会报错。