package org.chp.sboot.mixed;

import org.chp.sboot.mixed.task.AsyncTask;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jeff
 * <p>Date: 2019-11-12 21:02:00</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MixedApplicationTest {

    @Autowired
    private AsyncTask asyncTask;


}
