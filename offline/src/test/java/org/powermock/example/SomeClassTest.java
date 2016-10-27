package org.powermock.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(org.powermock.example.Configuration.class)
public class SomeClassTest {

    @Test
    public void shouldReturnSumIfEnabled() throws Exception {
        mockStatic(Configuration.class);
        doReturn(true).when(org.powermock.example.Configuration.class, "isEnabled");

        assertThat(new SomeClass().add(1, 5)).isEqualTo(6);
    }

    @Test
    public void shouldReturnZeroIfDisabled() throws Exception {
        mockStatic(Configuration.class);
        doReturn(false).when(Configuration.class,"isEnabled");

        assertThat(new SomeClass().add(1, 5)).isEqualTo(0);
    }
}