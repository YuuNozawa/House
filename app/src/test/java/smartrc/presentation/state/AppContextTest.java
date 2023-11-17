// package smartrc.presentation.state;

// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.context.annotation.Description;

// public class AppContextTest {
//     @Mock
//     private HomeState homeState;
//     @Mock
//     private LightState lightState;
//     @Mock
//     private LeaveState leaveState;

//     @BeforeEach
//     private void createMock() {
//         MockitoAnnotations.initMocks(this);
//     }

//     @Test
//     @Description("HomeStateのルーティングが正しいことを確認する")
//     public void homeStateRouteTest() {
//         new AppContext(homeState, lightState, leaveState);
//     }
// }
