import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BurgerTest {

    private static final float DELTA = 0.0001f;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    private Burger burger;

    @BeforeEach
    void setUp() {
        burger = new Burger();
    }

    @Test
    @DisplayName("Проверка метода setBun()")
    void setBunTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    @DisplayName("Проверка повторного вызова setBun() - перезапись булочки")
    void setBunTwiceTest() {
        burger.setBuns(bun);
        Bun newBun = org.mockito.Mockito.mock(Bun.class);
        burger.setBuns(newBun);
        assertEquals(newBun, burger.bun);
    }

    @Test
    @DisplayName("Проверка метода добавления ингредиента addIngredient()")
    void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    @DisplayName("Проверка метода удаления ингредиента removeIngredient()")
    void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }





}
