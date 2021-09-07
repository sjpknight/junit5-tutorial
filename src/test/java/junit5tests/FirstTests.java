package junit5tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstTests {

    @BeforeAll
    void beforeAll() {
        System.out.println("-- This is the before ALL method");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("---- This is the before EACH method");
    }

    @AfterAll
    void afterAll() {
        System.out.println("-- This is the after ALL method");
    }

    @AfterEach
    void afterEach() {
        System.out.println("---- This is the after EACH method");
    }

    @Test
    void firstMethod() {
        System.out.println("This is the 1st test method");
    }

    @Test
    @DisplayName("covering reference TR-3129 - relating to TC12 - second step")
    void secondMethod() {
        System.out.println("This is the 2nd test method");
    }
}
