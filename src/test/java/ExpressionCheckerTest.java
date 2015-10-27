import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by malance on 15/10/15.
 */
public class ExpressionCheckerTest {
    @Test
    public void test(){
        ExpressionChecker expressionChecker = new ExpressionChecker();
        assertTrue(expressionChecker.chkLegal("[a+b*(5-4)]*{x+b+b*({1+2)}}"));
        assertFalse(expressionChecker.chkLegal("[a+b*(5-4)]*{x+b+b*(({1+2)}}"));
        assertFalse(expressionChecker.chkLegal("w-{o*c-j*z+k-h+w+w*j+m-n}+m-t-g+k*f*f-e+f+u*s+y-s-v*s-f+x-q-m*(d*n)+c+j*s*v+k*y+c+t+v+o+m-s*a*e-i*p+y-c*a+z-g*v-c*a-h+(a+(y+i+e*x+u-r+m-d*i-n)*k+d*i-x+i*o*n+h-m-s-o*d-[x+x*e-d-h)*b*d*x*h*x*a*y-n*r*p*q-(b*a+v*{n*t*b+m)+[i-h+s*c*g*j*p+p]*{q-(l-f+d)+b]+m+g-p-w"));
        assertFalse(expressionChecker.chkLegal("g+{p+z-v"));
    }
}
