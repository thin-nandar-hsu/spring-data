package com.example.zoodemo.service;

import com.example.zoodemo.dao.*;
import com.example.zoodemo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnimalService {

    @Autowired
    private final CageDao cageDao;

    @Autowired
    private final SupplierDao supplierDao;

    @Autowired
    private final CategoryDao categoryDao;

    public AnimalService(CageDao cageDao,  SupplierDao supplierDao,  CategoryDao categoryDao) {
        this.cageDao = cageDao;
        this.supplierDao = supplierDao;
        this.categoryDao = categoryDao;
    }
//    @Autowired
//    private final AnimalDao animalDao;

    @Transactional
    public void createDb(){
        Cage cage1=new Cage("01","Yangon");
        Cage cage2=new Cage("02","Myawadi");
        Cage cage3=new Cage("03","Chin");

        Animal animal1 = new Animal("Mammal",4);
        Animal animal2 = new Animal("Fish",6);
        Animal animal3 = new Animal("Polar",5);

        Category cat1 = new Category("Monkey");
        Category cat2 = new Category("Hone");

        Supplier sup = new Supplier("MuShi","09876543","Yangon");

        FoodItem food1 = new FoodItem("Banana",3);
        FoodItem food2 = new FoodItem("Meal",5);


        cage1.setAnimal(animal1);
        animal1.setCage(cage1);
        cage2.setAnimal(animal2);
        animal2.setCage(cage2);
        cage3.setAnimal(animal3);
        animal3.setCage(cage3);


        cat1.addAnimal(animal1);
        cat1.addAnimal(animal2);
        cat2.addAnimal(animal3);


        sup.addFoodItem(food1);
        sup.addFoodItem(food2);

        animal1.addFoodItem(food1);
        animal1.addFoodItem(food2);



        cageDao.save(cage1);
        cageDao.save(cage2);
        cageDao.save(cage3);

        categoryDao.save(cat1);
        categoryDao.save(cat2);

        supplierDao.save(sup);



    }
}
