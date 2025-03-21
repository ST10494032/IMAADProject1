package vcmsa.ci.imaadprojec1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val inputTime: EditText = findViewById(R.id.inputTime)
        val buttonSuggest: Button = findViewById(R.id.buttonSuggestion)
        val buttonReset: Button = findViewById(R.id.buttonReset)
        val txtSuggestion: TextView = findViewById(R.id.textSuggestion)

        buttonSuggest.setOnClickListener {
            val timeOfDay = inputTime.text.toString().trim().lowercase()
            val suggestion = getMealSuggestion(timeOfDay)
            txtSuggestion.text = suggestion
        }
        buttonReset.setOnClickListener {
            inputTime.text.clear()
            txtSuggestion.text = ""



            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }

    private fun getMealSuggestion(timeOfDay: String): String {
        return when (timeOfDay) {
            "morning" -> "Breakfast: Eggs, Toast,  Cereal, French toast"
            "mid-morning" -> "Light snack: Smoothy, Provita and Cream cheese"
            "afternoon" -> "Lunch: Sandwich, Chicken Strips, Salad"
            "mid-afternoon" -> "Quick bites: Pepper mint tart, Fruit"
            "dinner" -> "Main course: Pasta, Roast chicken, Rice"
            "after dinner" -> "Desserts: Stawberry Ice cream"
            else -> "Invalid input. Please enter a valid time of day."
        }
    }
}