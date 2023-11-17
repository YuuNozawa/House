package smartrc.presentation.controller;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import smartrc.model.LightModel;
import smartrc.service.LightService;

public class LightControllerTest {
    private final LightModel lightModel = new LightModel(1000, false);

    @Mock
    LightService mockLightService;

    @BeforeEach
    public void createMock() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("照明画面の表示前にライトの状態を取得していること")
    public void test001() throws IOException{
        LightController lightController = new LightController(mockLightService);
        Mockito.doReturn(lightModel).when(mockLightService).getLight(anyInt());

        lightController.display();
        verify(mockLightService, times(1)).getLight(anyInt());
    }

    @Test
    @DisplayName("")
    public void test002() throws IOException{
    }
}
