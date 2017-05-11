package domain;

import domain.shapes.CirkelTest;
import domain.shapes.LijnStukTest;
import domain.shapes.PuntTest;
import domain.shapes.RechthoekTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({PuntTest.class, SpelerTest.class, CirkelTest.class, RechthoekTest.class, LijnStukTest.class})
public class AllTests {

}
