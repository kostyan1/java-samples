/*
 * Copyright (c) 1997-2013 InfoReach, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * InfoReach ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with InfoReach.
 *
 * CopyrightVersion 2.0
 */
package samples.kostyan.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;

/**
 * TODO: add description
 *
 * @author konstam
 */
public class StreamsSamples
{

    public static void main(String[] args)
    {
        groupingBySample();
    }

    static void groupingBySample()
    {
        //regular
        Map<String, List<Person>> byCountryMap = Arrays.stream(persons_).collect(groupingBy(Person::getCountry));
        System.out.println("byCountryMap = " + byCountryMap);
        final Map<Integer, List<Person>> byAgeMap = Arrays.stream(persons_).collect(groupingBy(Person::getAge));
        System.out.println("byAgeMap = " + byAgeMap);

        //with 'downstream' provided (counting)
        final Map<String, Long> byCountryFrequencyMap = Arrays.stream(persons_).collect(groupingBy(Person::getCountry, counting()));
        System.out.println("byCountryFrequencyMap = " + byCountryFrequencyMap);
    }



    final static Person[] persons_ = new Person[]{
            new Person.PersonBuilder().name("ivan").age(3).country("USA").build(),
            new Person.PersonBuilder().name("peter").age(45).country("Denmark").build(),
            new Person.PersonBuilder().name("nikita").age(10).country("Ukraine").build(),
            new Person.PersonBuilder().name("kostya").age(42).country("USA").build(),
            new Person.PersonBuilder().name("vita").age(39).country("USA").build(),
            new Person.PersonBuilder().name("oksana").age(39).country("Ukraine").build(),
    };

    static class Person
    {
        final String name_;
        final int age_;
        final String country_;

        Person(String name_, int age_, String country_) {
            this.name_ = name_;
            this.age_ = age_;
            this.country_ = country_;
        }

        public String getName() {
            return name_;
        }

        public int getAge() {
            return age_;
        }

        public String getCountry() {
            return country_;
        }

        @Override
        public String toString() {
            return "Person{" + name_ + '\'' +
                    " " + age_ +
                    " " + country_ + '\'' +
                    '}';
        }

        static class PersonBuilder {
            private String name_;
            private int age_;
            private String country_;

            public PersonBuilder name(String name_) {
                this.name_ = name_;
                return this;
            }

            public PersonBuilder age(int age_) {
                this.age_ = age_;
                return this;
            }

            public PersonBuilder country(String country_) {
                this.country_ = country_;
                return this;
            }

            public Person build() {
                return new Person(name_, age_, country_);
            }
        }
    }
}
