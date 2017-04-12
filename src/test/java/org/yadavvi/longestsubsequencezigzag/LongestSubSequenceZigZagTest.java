package org.yadavvi.longestsubsequencezigzag;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by vishal on 10/4/17.
 */
@RunWith(JUnitParamsRunner.class)
public class LongestSubSequenceZigZagTest {
    private LongestSubSequenceZigZag longestSubSequenceZigZag;

    public Object[] sequencesAndLengthOfSubSequence() {
        return new Object[]{
                new Object[]{new int[]{1}, 1},
                new Object[]{new int[]{1, 2}, 2},
                new Object[]{new int[]{1, 2, 3}, 2},
                new Object[]{new int[]{1, 2, 0}, 3},
                new Object[]{new int[]{1, 2, 0, -1}, 3},
                new Object[]{new int[]{1, 2, 3, 4}, 2},
                new Object[]{new int[]{4, 3, 2, 1}, 2},
                new Object[]{new int[]{1, 7, 4, 9, 2, 5}, 6},
                new Object[]{new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}, 7},
                new Object[]{new int[]{44}, 1},
                new Object[]{new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 2},
                new Object[]{new int[]{70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32}, 8},
                new Object[]{new int[]{70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32}, 8},
                new Object[]{new int[]{374, 40, 854, 203, 203, 156, 362, 279, 812, 955,
                        600, 947, 978, 46, 100, 953, 670, 862, 568, 188,
                        67, 669, 810, 704, 52, 861, 49, 640, 370, 908,
                        477, 245, 413, 109, 659, 401, 483, 308, 609, 120,
                        249, 22, 176, 279, 23, 22, 617, 462, 459, 244}, 36}
        };
    }

    @Before
    public void setUp() throws Exception {
        longestSubSequenceZigZag = new LongestSubSequenceZigZag();
    }

    @Test
    @Parameters(method = "sequencesAndLengthOfSubSequence")
    public void longestZigZag(int[] sequence, int length) throws Exception {
        assertThat(longestSubSequenceZigZag.longestZigZag(sequence), is(length));
    }

    @Test
    @Parameters(method = "sequencesAndLengthOfSubSequence")
    public void longestZigZagDP(int[] sequence, int length) throws Exception {
        assertThat(longestSubSequenceZigZag.longestZigZagDP(sequence), is(length));
    }

}