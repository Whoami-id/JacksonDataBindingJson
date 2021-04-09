
package com.luv2code.jackson.json.demo;

import java.io.File;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

    public static void main(final String[] args) {

        try {

            // create object mapper
            final ObjectMapper mapper = new ObjectMapper();

            // read JSON file and map/convert to Java POJO:
            // data/sample-lite.json
            final Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);

            // print first name and last name
            System.out.println("First name:" + student.getFirstName());
            System.out.println("Last name:" + student.getLastName());

            final Address address = student.getAddress();
            System.out.println("Street: " + address.getStreet());

            final Stream<String> stream = Stream.of(student.getLanguages());
            stream.forEach(System.out::println);

        } catch (final Exception ex) {
            ex.printStackTrace();
        }

    }

}
