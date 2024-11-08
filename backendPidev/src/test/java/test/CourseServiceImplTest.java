package test;

import com.pidev.backend.Controller.CourseController;
import com.pidev.backend.Entity.Course;
import com.pidev.backend.Service.CourseService;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

class CourseControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CourseService courseService;

    @InjectMocks
    private CourseController courseController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(courseController).build();
    }

    @Test
    void testGetAllCourses() throws Exception {
        // Création de quelques objets Course
        Course course1 = new Course();
        course1.setId("1");
        course1.setCourseName("Course One");
        course1.setCourseLevel("Beginner");

        Course course2 = new Course();
        course2.setId("2");
        course2.setCourseName("Course Two");
        course2.setCourseLevel("Intermediate");

        // Liste de cours
        List<Course> courses = Arrays.asList(course1, course2);

        // Simulation du comportement du service
        when(courseService.getALLCourses()).thenReturn(courses);

        // Effectuer la requête et vérifier les résultats
        mockMvc.perform(get("/courses/retrieve-courses")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())  // Vérifier que la réponse est OK
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))  // Vérifier le type MIME
                .andExpect(jsonPath("$", hasSize(2)))  // Vérifier que la liste contient 2 éléments
                .andExpect(jsonPath("$[0].id", is("1")))  // Vérifier les propriétés du premier cours
                .andExpect(jsonPath("$[0].courseName", is("Course One")))
                .andExpect(jsonPath("$[0].courseLevel", is("Beginner")))
                .andExpect(jsonPath("$[1].id", is("2")))  // Vérifier les propriétés du deuxième cours
                .andExpect(jsonPath("$[1].courseName", is("Course Two")))
                .andExpect(jsonPath("$[1].courseLevel", is("Intermediate")));
    }
}
