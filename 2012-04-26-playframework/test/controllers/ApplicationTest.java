package controllers;

import org.junit.Test;
import play.mvc.Http;
import play.mvc.Result;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.callAction;
import static play.test.Helpers.status;

public class ApplicationTest {

    @Test
    public void testIndex() throws Exception {
        Result result = callAction(routes.ref.Application.index());
        assertThat(status(result)).isEqualTo(Http.Status.SEE_OTHER);
    }

    @Test
    public void testTasks() throws Exception {
        // fix this test
    }

    @Test
    public void testNewTask() throws Exception {
        // fix this test
    }

    @Test
    public void testDeleteTask() throws Exception {
        // fix this test
    }
}
