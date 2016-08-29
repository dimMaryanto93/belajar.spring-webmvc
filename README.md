# Belajar Spring Framework - MVC &amp; Data JPA

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
