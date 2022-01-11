package com.example.restaurantapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.cleveroad.fanlayoutmanager.FanLayoutManager
import com.cleveroad.fanlayoutmanager.FanLayoutManagerSettings
import com.example.restaurantapp.adapter.FoodsAdapter
import com.example.restaurantapp.FoodData
import com.example.restaurantapp.R
import kotlinx.android.synthetic.main.activity_home_screen.*
import androidx.recyclerview.widget.GridLayoutManager
import com.example.restaurantapp.adapter.Expandable
import com.kapil.circularlayoutmanager.CircularLayoutManager
import com.littlemango.stacklayoutmanager.StackLayoutManager
import com.stone.vega.library.VegaLayoutManager
import kotlinx.android.synthetic.main.additem.*


class HomeScreen : AppCompatActivity() {

    /* lateinit var binding: ActivityHomeScreenBinding

    lateinit var recyclerview: RecyclerView
    lateinit var adapter: FanLayoutRecycler
    lateinit var list: ArrayList<DataModel>*/

    private lateinit var mFoodsAdapter: FoodsAdapter
    private lateinit var mFoodData: ArrayList<FoodData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        mFoodData = ArrayList<FoodData>()
        mFoodsAdapter = FoodsAdapter(this, mFoodData)
        foodRecycler.layoutManager = LinearLayoutManager(this)
        foodRecycler.adapter = mFoodsAdapter


        /*foodRecycler.addItemDecoration(
            DividerItemDecoration(
                getActivity(),
                DividerItemDecoration.VERTICAL_LIST
            )
        )*/
        /**set list*/
        listFruits()

        val languages = resources.getStringArray(R.array.filters)

        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_list, languages)
        autoCompleteTextView.setAdapter(arrayAdapter)
/*        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
     //   list= arrayListOf()
        val languages = resources.getStringArray(R.array.filters)

        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_list, languages)

        binding.autoCompleteTextView.setAdapter(arrayAdapter)*/




        autoCompleteTextView.setOnItemClickListener { adapterView, view, position, l ->
            Toast.makeText(HomeScreen@ this, languages.get(position), Toast.LENGTH_LONG).show()
            if ("Fan Layout".equals(languages[position]))
                FanLayoutCall()
            else if ("Stack Layout".equals(languages[position]))
                stacklayout()
            else if ("Vega Layout".equals(languages[position]))
                circularLayout()
            else if ("Grid Layout".equals(languages[position]))
                gridlayout()


        }

       addfloating.setOnClickListener{
           addinfo()
    }


    }

    private fun addinfo() {
        val inflter = LayoutInflater.from(this)
        val v = inflter.inflate(R.layout.additem,null)



        val addDialog = AlertDialog.Builder(this)
        val foodName = v.findViewById<EditText>(R.id.foodName)
        val foodDes = v.findViewById<EditText>(R.id.foodDes)
        addDialog.setView(v)
        addDialog.setPositiveButton("Ok"){
                dialog,_->
            val names = foodName.text.toString()
           val des= foodDes.text.toString()
            mFoodData.add(FoodData(R.drawable.icecream, " $names", " $des", 5, 400))
            mFoodsAdapter.notifyDataSetChanged()

            Toast.makeText(this,"Item Added Successfully",Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel"){
                dialog,_->
            dialog.dismiss()
            Toast.makeText(this,"Cancel",Toast.LENGTH_SHORT).show()

        }
        addDialog.create()
        addDialog.show()
    }



    fun listFruits() {
        mFoodData.add(
            FoodData(
                R.drawable.pizza,
                "1. Pizza",
                "The ever-popular Margherita - loaded with extra cheese... oodies of it!",
                5,
                400
            )
        )
        mFoodData.add(
            FoodData(
                R.drawable.egg,
                "2. Egg",
                "All omelettes are prepared with the freshest ingredients, made with 2 eggs & served with grits & white, wheat or raisin toast.",
                5,
                400
            )
        )
        mFoodData.add(
            FoodData(
                R.drawable.donut,
                "3. Donuts",
                "traditional ring shape and the method of frying in hot oil. Yeast-leavened donuts are porous, resilient and have a bread-like crumb structure.",
                5,
                400
            )
        )
        mFoodData.add(
            FoodData(
                R.drawable.pizza,
                "4. Pizza ",
                "A pizza that decidedly staggers under an overload of golden corn, exotic black olives, crunchy onions, crisp capsicum, succulent mushrooms, juicyfresh tomatoes and jalapeno - with extra cheese to go all around.",
                5,
                400
            )
        )
        mFoodData.add(
            FoodData(
                R.drawable.french_fries,
                "5. French fires",
                "French fries have numerous variants, from thick-cut to shoestring, crinkle, curly and many other names. They are readily available at restaurants or Mac Donald outlets.",
                5,
                400
            )
        )
        mFoodData.add(
            FoodData(
                R.drawable.sandwich,
                "6. Grill Sandwich ",
                "1 ⅓ cups of chunks (224 grams): 100 calories and 20 grams sugar",
                5,
                400
            )
        )
        mFoodData.add(
            FoodData(
                R.drawable.sandwich4,
                "7. sandwich ",
                "A grilled cheese sandwich is assembled by creating a cheese filling, often cheddar, or American, between two slices of bread",
                5,
                400
            )
        )
        mFoodData.add(
            FoodData(
                R.drawable.lunch,
                "8. Salad ",
                " a tossed salad usually made of romaine, garlic, anchovies, and croutons and dressed with olive oil, coddled egg, lemon juice, and grated cheese.",
                5,
                400
            )
        )
        mFoodData.add(
            FoodData(
                R.drawable.burger,
                "9. Burger",
                "Juicy, big, loaded with toppings of my choice",
                5,
                400
            )
        )
        mFoodData.add(
            FoodData(
                R.drawable.breakfast,
                "10. Breakfast",
                "A continental breakfast is a light morning meal typically consisting of pastries and baked goods, fruits, toast, and coffee. ",
                5,
                400
            )
        )
        mFoodData.add(
            FoodData(
                R.drawable.icecream,
                "11. Icecream",
                "Ice cream is a sweetened frozen food typically eaten as a snack or dessert. It may be made from dairy milk or cream and is flavoured with a sweetener",
                5,
                400
            )
        )
        mFoodData.add(
            FoodData(
                R.drawable.cofee,
                "12. Coffee",
                "One medium pear (166 grams): 100 calories and 16 grams sugar",
                5,
                400
            )
        )
        mFoodData.add(
            FoodData(
                R.drawable.sandwich,
                "13. Sandwich",
                "About three small-to-medium kiwis (164.4 grams): 100 calories and 14.44 grams sugar",
                5,
                400
            )
        )
        mFoodData.add(
            FoodData(
                R.drawable.sandwich,
                "14. Sandwich ",
                "1 cup or about 21 cherries (140 grams): 100 calories and 6 grams sugar",
                5,
                400
            )
        )
        mFoodData.add(
            FoodData(
                R.drawable.sandwich,
                "15. Sandwich",
                "About 24 grapes or ¾ cup (140 grams): 100 calories and 22.2 grams sugar",
                5,
                400
            )
        )
        mFoodData.add(
            FoodData(
                R.drawable.sandwich,
                "16. Sandwich ",
                "About four-fifths of one medium banana (114.55 grams): 100 calories and 17.27 grams sugar",
                5,
                400
            )
        )
        mFoodData.add(
            FoodData(
                R.drawable.sandwich,
                "17. Sandwich ",
                "About three-fifths of one small avocado (60 grams): 100 calories and 0 grams sugar",
                5,
                400
            )
        )
    }


    fun FanLayoutCall() {

        mFoodsAdapter = FoodsAdapter(this, mFoodData)

        val fanLayoutManagerSettings = FanLayoutManagerSettings
            .newBuilder(this)
            .withFanRadius(true)
            .withAngleItemBounce(8f)
            .withViewWidthDp(250f)
            .withViewHeightDp(180f)
            .build()

        foodRecycler.layoutManager = FanLayoutManager(this, fanLayoutManagerSettings)
        foodRecycler.adapter = mFoodsAdapter


    }

    fun gridlayout() {

        mFoodsAdapter = FoodsAdapter(this, mFoodData)
        foodRecycler.layoutManager = GridLayoutManager(this, 2)
        foodRecycler.adapter = mFoodsAdapter
    }

    fun vegalayout() {
//        mFoodData.clear()
        mFoodsAdapter = FoodsAdapter(this, mFoodData)
Toast.makeText(applicationContext,"in vega layout",Toast.LENGTH_LONG).show()
        val vega = VegaLayoutManager()
       // vega.canScrollHorizontally()

        foodRecycler.layoutManager = vega
        foodRecycler.adapter = mFoodsAdapter


    }


    fun circularLayout() {

        //val layoutcircle=CircularLayoutManager(10.5,65.1)
        //val layoutcircle=CircularLayoutManager(this,null,0,0)

        //val layoutcircle= CircularLayoutManager1(this,null,0,0)
        val layoutcircle = CircularLayoutManager(
            "150.2".toString().toFloat(),
            "300.0".toString().toFloat(),
            "250.0".toString().toFloat()
        )
        val adapterdemo = FoodsAdapter(this, mFoodData)
        foodRecycler.layoutManager = layoutcircle
        foodRecycler.adapter = adapterdemo


    }
    fun stacklayout() {

        val stacklayoutmanager = StackLayoutManager()
        stacklayoutmanager.setItemOffset(10)
        val adapterdemo = Expandable(this, mFoodData)


        foodRecycler.layoutManager = stacklayoutmanager
        foodRecycler.adapter = adapterdemo
    }


}
