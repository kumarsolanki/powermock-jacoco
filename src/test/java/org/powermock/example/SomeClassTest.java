package org.powermock.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Configuration.class)
public class SomeClassTest {

    @Test
    public void shouldReturnSumIfEnabled() throws Exception {
        mockStatic(Configuration.class);
        doReturn(true).when(Configuration.class,"isEnabled");

        assertThat(new SomeClass().add(1, 5)).isEqualTo(6);
    }

    @Test
    public void shouldReturnZeroIfDisabled() throws Exception {
        mockStatic(Configuration.class);
        doReturn(false).when(Configuration.class,"isEnabled");

        assertThat(new SomeClass().add(1, 5)).isEqualTo(0);
    }
}