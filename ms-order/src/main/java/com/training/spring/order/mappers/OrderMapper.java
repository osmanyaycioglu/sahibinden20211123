package com.training.spring.order.mappers;

import java.util.ArrayList;
import java.util.List;

import com.training.spring.order.models.Order;
import com.training.spring.order.rest.models.MealRestObj;
import com.training.spring.order.rest.models.OrderRestObj;
import com.training.spring.restaurant.rest.models.Meal;

public class OrderMapper {

    public static Order toOrder(final OrderRestObj orderParam) {
        Order orderLoc = new Order();
        orderLoc.setName(orderParam.getName());
        orderLoc.setSurname(orderParam.getSurname());
        orderLoc.setPhone(orderParam.getPhone());
        orderLoc.setHour(orderParam.getHour());
        orderLoc.setMeals(toMeals(orderParam.getMeals()));
        return orderLoc;
    }

    public static List<Meal> toMeals(final List<MealRestObj> mealsParam) {
        List<Meal> listLoc = new ArrayList<>();
        for (MealRestObj mealRestObjLoc : mealsParam) {
            listLoc.add(toMeals(mealRestObjLoc));
        }
        return listLoc;
    }

    public static Meal toMeals(final MealRestObj mealRestObjParam) {
        return new Meal().setMeal(mealRestObjParam.getMeal())
                         .setCount(mealRestObjParam.getCount());
    }


}
