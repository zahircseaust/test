# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.10/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.10/maven-plugin/reference/html/#build-image)

* CREATE TABLE `product` (
  `pid` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `qty` int(11) NOT NULL,
  `cp_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `FKm2yengq9w1m07kk7qndvhxhyd` (`cp_fk`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1
  ========
  CREATE TABLE product (
  pid int NOT NULL,
  price int NOT NULL,
  product_name varchar(255) NULL,
  qty int NOT NULL,
  cp_fk int NULL,
  CONSTRAINT PK_product PRIMARY KEY (pid),
  CONSTRAINT FK_product_cp FOREIGN KEY (cp_fk) REFERENCES other_table(cp_column)
);


