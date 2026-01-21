package generics;


interface MealPlanner { String getName(); }

class VegetarianMeal implements MealPlanner { public String getName(){ return "Vegetarian"; } }
class VeganMeal implements MealPlanner { public String getName(){ return "Vegan"; } }
class KetoMeal implements MealPlanner { public String getName(){ return "Keto"; } }

class Meal<T extends MealPlanner> {
    private T plan;
    public Meal(T plan) { this.plan = plan; }
    public T getPlan() { return plan; }
    @Override public String toString() { return "MealPlan: " + plan.getName(); }
}

// Renamed class to avoid collision with interface
public class MealPlannerDemo {

    public static <T extends MealPlanner> Meal<T> generateMealPlan(T plan) {
        System.out.println("Generating meal plan: " + plan.getName());
        return new Meal<>(plan);
    }

    public static void main(String[] args) {
        Meal<VegetarianMeal> m1 = generateMealPlan(new VegetarianMeal());
        Meal<VeganMeal> m2       = generateMealPlan(new VeganMeal());
        Meal<KetoMeal> m3        = generateMealPlan(new KetoMeal());

        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
    }
}
