package org.yadavvi.longestsubsequence;

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
public class LongestSubSequenceTest {

    private LongestSubSequence longestSubSequence;

    public Object[] sequenceAndLengthOfSubSequence() {
        return new Object[]{
                new Object[]{new int[]{1, 2, 3, 4}, 4},
                new Object[]{new int[]{5, 3, 4, 8, 6, 7}, 4},
                new Object[]{new int[]{1, 2, 3, 5, 8, 5, 7}, 6}
        };
    }

    @Before
    public void setUp() throws Exception {
        longestSubSequence = new LongestSubSequence();
    }

    @Test
    @Parameters(method = "sequencesAndLengthOfSubSequence")
    public void longestNonDecreasingSubSequence(int[] sequence, int length) throws Exception {
        assertThat(longestSubSequence.longestNonDecreasingSubSequence(sequence), is(length));
    }

}