# Belajar Spring Framework - MVC & Data JPA

Ini adalah contoh aplikasi menggunakan Spring MVC dan Spring Data JPA dengan implementasi ORM Hiberhate dan menggunakan PostgreSQL sebagai Databasenya.


## Membuat project dengan Maven

```bash
mvn archetype:generate
  -DartifactId=belajar.spring-mvc.java-config
  -DgroupId=com.hotmail.dimmaryanto.software
  -DarchetypeCatalog='internal'
  -DarcehtypeArtifactId=maven-archetype-webapp
  -Dversion=1.0
```

Setelah project terbuat kita seperti biasa tambahkan dependency untuk aplikasi java web seperti ```servlet-api```, ```jstl```, ```jsp-api``` dan ```junit```:

```xml
<dependency>
  <groupId>junit</groupId>
  <artifactId>junit</artifactId>
  <version>4.12</version>
  <scope>test</scope>
</dependency>
<dependency>
  <groupId>javax.servlet</groupId>
  <artifactId>javax.servlet-api</artifactId>
  <version>3.1.0</version>
  <scope>provided</scope>
</dependency>
<dependency>
  <groupId>jstl</groupId>
  <artifactId>jstl</artifactId>
  <version>1.2</version>
</dependency>
```

Kemudian tambahkan plugin ```maven-compiler-plugin``` dan ```tomcat7-maven-plugin``` seperti berikut:

```xml
<build>
  <finalName>Belajar Spring MVC</finalName>
  <plugins>
    <plugin>
      <groupId>org.apache.tomcat.maven</groupId>
      <artifactId>tomcat7-maven-plugin</artifactId>
      <version>2.2</version>
    </plugin>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-compiler-plugin</artifactId>
      <version>3.5.1</version>
      <configuration>
        <target>1.7</target>
        <source>1.7</source>
      </configuration>
    </plugin>
    <!-- plugin lainnya -->
  </plugins>
</build>
```

setelah itu coba dirunning dengan menggunakan perintah maven seperti berikut:

```bash
mvn clean package tomcat7:run
```

setelah itu coba browsernya dibuka terus masukan alamat berikut:

```
http://localhost:8080/belajar.spring-mvc.java-config/
```

## Spring WebMVC

Setelah konfigurasi maven project webnya udah berhasil dijalankan langkah selanjutnya membuat konfigurasi Spring MVC, syaratnya untuk membuat konfigurasi Spring MVC dengan JSP adalah kita tambahkan dulu dependencynya ```spring-context```, ```spring-webmvc``` dan ```spring-test``` (optional) seperti berikut:

```xml
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-context</artifactId>
  <version>4.3.2.RELEASE</version>
</dependency>
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-webmvc</artifactId>
  <version>4.3.2.RELEASE</version>
</dependency>
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-test</artifactId>
  <version>4.3.2.RELEASE</version>
</dependency>
```

Sekarang kita baru bisa melakukan konfigurasi si ```spring-webmvc```nya, sebenarnya 2 cara yaitu dengan menggunakan servlet descriptor (xml) dan juga Java Konfig untuk membuat ```spring-webmvc```, tapi kali ini saya mau pake Java Config karena jaman sekarang semuanya udah pake Java Config seperti yang diusulkan oleh ```spring-boot``` semuanya pake Java Config. ok Sekarang kita tinggal bikin konfigurasi webnya:

buat kelas dengan nama ```KonfigurasiWeb.java``` dalam package ```spring.mvc.belajar``` seperti berikut:

```java
package spring.mvc.belajar;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "spring.mvc.belajar")
public class KonfigurasiWeb extends WebMvcConfigurerAdapter {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		super.configureViewResolvers(registry);
    // untuk menghandle file jsp ke spring mvc
		registry.jsp("/WEB-INF/pages/", ".jsp");
	}

}
```

buat kelas dengan nama ```AnnotationWebInitializer.java``` dalam package ```spring.mvc.belajar.konfigurasi``` isinya seperti berikut:

```java
package spring.mvc.belajar.konfigurasi;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import spring.mvc.belajar.KonfigurasiWeb;

public class AnnotationWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
    // daftarkan spring konfigurasi web ke servlet config
    // sama dengan file web.xml (java web descriptor) mapping-url dispatcher-servlet.xml
		return new Class[] { KonfigurasiWeb.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
```

setelah itu coba buat file ```halo.jsp``` dalam folder ```src/main/webapp/WEB-INF/pages/``` seperti berikut:

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!-- isELignored = "false" // untuk mengaktifkan JSP Expresion karena secara default maven meng-disable EL -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
  </head>
  <body>
  	${message}
  </body>
</html>
```

Kemudian buat controllernya di dalam package ```com.hotmail.dimmaryanto.software.aksi``` dengan nama class ```HaloController``` seperti berikut:

```java
package spring.mvc.belajar.aksi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HaloController {

	@RequestMapping("/halo")
	public ModelMap halo() {
		ModelMap map = new ModelMap();
		map.addAttribute("message", "Halo, nama saya dimas maryanto");
		return map;
	}
}
```

Setelah itu coba anda running dengan maven tomcat7. dan coba akses ```http://localhost:8080/belajar.spring-mvc.java-config/halo```

Maka browser akan manghasilkan output yaitu ```Halo, nama saya dimas maryanto```

## Spring Data JPA

Setelah kita mengconfigurasi ```spring-webmvc``` sekarang saya konfigurasi ```spring-data-jpa``` untuk menggunakan fitur ORM dengan menggunakan database PostgreSQL, seperti biasa kita tambahkan dulu dependencynya seperti berikut:

```xml
<dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-jpa</artifactId>
    <version>1.10.2.RELEASE</version>
</dependency>

<!-- hibernate -->
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-entitymanager</artifactId>
    <version>5.1.0.Final</version>
</dependency>
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>5.1.3.Final</version>
</dependency>

<!-- database driver -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>9.4-1206-jdbc42</version>
</dependency>
<dependency>
    <groupId>commons-dbcp</groupId>
    <artifactId>commons-dbcp</artifactId>
    <version>1.4</version>
</dependency>
```

Setelah itu kita cukup tambahkan ```@EnableJpaRepository``` di kelas ```KonfigurasiWeb``` untuk mengaktifkan ```spring-data-jpa```, setelah itu kita harus buat configurasi untuk ```DataSource```, ```SessionFactory``` atau bisa pake ```EntityManagerFactory``` dan yang terakhir ```JpaTransactionManager``` seperti berikut:

```java
package spring.mvc.belajar;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "spring.mvc.belajar")
// untuk meng-scan dimana keberadaan @Entity dan @Repository atau extends CrudRepository dan PagingAndSortingRepsitory
@EnableJpaRepositories(basePackages = "spring.mvc.belajar")
public class KonfigurasiWeb extends WebMvcConfigurerAdapter {

  // konfigurasi jsp view resolver goes here

	@Bean
	public DataSource dataSource() {
		BasicDataSource dbcp = new BasicDataSource();

		dbcp.setDriverClassName("org.postgresql.Driver");
		dbcp.setUrl("jdbc:postgresql://localhost:5432/belajar-spring-mvc");
		dbcp.setUsername("postgres");
		dbcp.setPassword("admin");

		return dbcp;
	}

	@Bean
	@Autowired
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		// untuk menentukan package nama yang akan discan
		factory.setPackagesToScan("spring.mvc.belajar");
		// setting datasource
		factory.setDataSource(ds);

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		// set hibernate dialect = org.hibernate.dialect.PostgreSQL
		vendorAdapter.setDatabase(Database.POSTGRESQL);
		// set hibernate.hbm2dll.auto = true
		vendorAdapter.setGenerateDdl(true);
		// set hibernate.show-sql = true
		vendorAdapter.setShowSql(true);

		factory.setJpaVendorAdapter(vendorAdapter);
		return factory;
	}

	@Bean
	@Autowired
	public JpaTransactionManager transactionManager(EntityManagerFactory session) {
		JpaTransactionManager jpaTM = new JpaTransactionManager(session);
		return jpaTM;
	}

}
```

Setelah itu kita coba membuat domain class yaitu ```Mahasiswa``` dalam package ```spring.mvc.belajar.domain``` seperti berikut:

```java
package spring.mvc.belajar.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Mahasiswa {

	@Id
	private String id;
	private String nim;
	private String nama;

  // setter & getter goes here

}
```

Setelah itu kita biasa membuat CRUDnya dengan menggunakan kelas yang di sediakan oleh spring-data-jpa yaitu CrudRepository. sekarang kita buat interface dengan nama ```MahasiswaDao``` kemudian kita buat kelas tersebut extends ```CrudRepository<Mahasiswa, String>``` seperti berikut:

```java
package spring.mvc.belajar.dao;

import org.springframework.data.repository.CrudRepository;

import spring.mvc.belajar.domain.Mahasiswa;

public interface MahasiswaDao extends CrudRepository<Mahasiswa, String> {

  // untuk mencari data mahasiswa berdasarkan nim
	public Mahasiswa findByNim(String nim);

}
```

Sekarang kita buat Integration Testnya buat dalam folder ```src/test/java``` dalam package ```coba``` dan buat unit test dengan nama kelas ```SpringContext.java``` seperti berikut:

```java
package coba;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import junit.framework.TestCase;
import spring.mvc.belajar.KonfigurasiWeb;
import spring.mvc.belajar.dao.MahasiswaDao;
import spring.mvc.belajar.domain.Mahasiswa;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = KonfigurasiWeb.class)
@WebAppConfiguration
public class SpringContext extends TestCase {

	@Autowired
	private MahasiswaDao dao;

	@Test
	public void contextLoaded() {

	}

	@Test
	public void testCariSemuaMahasiswa() {
		Mahasiswa mhs = dao.findByNim("10511148");
		assertNotNull(mhs);
	}
}
```

Sekarang tinggal jalankan testnya dengan perintah seperti berikut:

```bash
mvn test
```

Jika berhasil berarti setup konfigurasi ```spring-webmvc``` dan ```spring-data-jpa``` udah berhasil dan jangan lupa sebelum menjalankan buat dulu databasenya seperti berikut:

```sql
CREATE DATABASE belajar-spring-mvc WITH OWNER postgres;
```
