package com.example.carcompany.service;

import com.example.carcompany.dao.*;
import com.example.carcompany.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class CarService {

    @Autowired
    private final CarDao carDao;



    @Autowired
    private final PersonDao personDao;

    @Autowired
    private final CarManuDao carManuDao;

    @Autowired
    private final CarInsuDao carInsuDao;

    public CarService(CarDao carDao, PersonDao personDao, CarManuDao carManuDao, CarInsuDao carInsuDao) {
        this.carDao = carDao;
        this.personDao = personDao;
        this.carManuDao = carManuDao;
        this.carInsuDao = carInsuDao;
    }

    @Transactional
    public void createDb(){

        Car car1 = new Car("005","Japan", LocalDate.of(2020,3,4),10);
        Car car2 = new Car("006","German",LocalDate.of(2019,6,4),40);
        Car car3 = new Car("007","USA",LocalDate.of(2020,10,4),40);

        CarManufacture cm1 = new CarManufacture("Sun",new Address("Japan","Dream Lane"),700);
        CarManufacture cm2 = new CarManufacture("Moon Light",new Address("German","Bridge Lane"),500);
        CarManufacture cm3 = new CarManufacture("Spring",new Address("USA","Love Lane"),900);

        InsuranceCompany im1 = new InsuranceCompany("Indigo",new Address("Yangon","Daw Na"),8);
        InsuranceCompany im2 = new InsuranceCompany("GGI",new Address("Shan","Nant San"),5);

        Person owner1 = new Person("Re Dono","1999-10-4");
        Person owner2 = new Person("Mu Shi","2000-3-6");
        Person owner3 = new Person("Yo Lo","1999-1-6");
        Person owner4 = new Person("Zu Zu","1999-10-4");
        Person owner5 = new Person("Lao Lao","1999-10-4");

//        Person driver1 = new Person("Mu Shi","2000-3-6");
//        Person driver2 = new Person("Yo Lo","2000-1-6");

        car1.setCarManufacture(cm1);
        cm1.setCar(car1);
        car2.setCarManufacture(cm2);
        cm2.setCar(car2);
        car3.setCarManufacture(cm3);
        cm3.setCar(car3);

        car1.addInsurance(im1);
        car2.addInsurance(im2);

        car1.addOwner(owner1);
        car1.addOwner(owner2);
        car2.addOwner(owner3);
        car2.addOwner(owner4);
        car3.addOwner(owner5);

        car1.addDriver(owner2);
        car2.addDriver(owner3);

        carManuDao.save(cm1);
        carManuDao.save(cm2);
        carManuDao.save(cm3);

        carDao.save(car1);
        carDao.save(car2);
        carDao.save(car3);


        personDao.save(owner1);
        personDao.save(owner2);
        personDao.save(owner3);
        personDao.save(owner4);
        personDao.save(owner5);

//        personDao.save(driver1);
//        personDao.save(driver2);

        carInsuDao.save(im1);
        carInsuDao.save(im2);



    }
}
