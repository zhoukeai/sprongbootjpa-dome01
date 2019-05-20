package com.offcn.dao;

import com.offcn.bean.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long>{

    //查询指定用户姓名的用户


    public Person findByNameIs(String name);

    //查询指定用户姓名和年龄都相同的用户

    public Person findByNameIsAndAge(String name,Integer age);


    //查询包含指定名字的用户
    public List<Person> findByNameContaining(String name);



    //查询指定用户姓名的用户

    @Query("select p from Person p where p.name=:name")
    public Person getPerson(@Param("name") String name);


    //查询指定用户姓名和年龄都相同的用户

    @Query("select p from Person p where p.name=?1 and p.age=?2")
    public Person getLogin(@Param("name")String name,@Param("age")Integer age);


    //查询包含指定名字的用户

    @Query("select p from Person p where p.name like %:name%")
    public List<Person> getNamesLike(@Param("name")String name);




@Query(value = "select * from person where length(age)=3",nativeQuery = true)
    public List<Person> getAgeisThree();



    // 排序查询，返回 list 集合
   public List<Person> findByNameContaining(String name, Sort sort);
    //分页查询，查询计算总个数，总页数
  public Page<Person> findByNameContaining(String name, Pageable pageable);

  //分页查询，返回的是一个片段，它只知道下一片段或者上一片段是否可用。

    Slice<Person> getByNameContaining(String name, Pageable pageable);


    //查询指定用户名称，按照 id 降序排序第一条记录
    public Person FindFirstByIdDesc(String name);



}
