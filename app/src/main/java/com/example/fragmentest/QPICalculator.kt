package com.example.fragmentest

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class QPICalculator : AppCompatActivity() {

    // Fields/Variables
    // Array containing inputted letter grades and units
    var grades_list = ArrayList<Double>()
    var units_list = ArrayList<Double>()

    // Temporary variables to contain recently pressed grade and unit
    var grade: Double? = null
    var units: Double? = null

    // Letter grade must be inputted first
    var is_LetterGrade: Boolean = true
    var is_SecondGrade: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qpicalculator)

        // EditText to Display Stuff
        val display_qpi: EditText = findViewById(R.id.etQPI)
        val display_equation: EditText = findViewById(R.id.etEquation)

        // Letter Grade Buttons
        val button_A: Button = findViewById(R.id.btnA)
        val button_BPlus: Button = findViewById(R.id.btnBP)
        val button_B: Button = findViewById(R.id.btnB)
        val button_CPlus: Button = findViewById(R.id.btnCP)
        val button_C: Button = findViewById(R.id.btnC)
        val button_D: Button = findViewById(R.id.btnD)
        val button_F: Button = findViewById(R.id.btnF)

        // Operation Buttons
        val button_clear: Button = findViewById(R.id.btnClear)
        val button_equal: Button = findViewById(R.id.btnEq)

        // Unit Buttons
        val button_3: Button = findViewById(R.id.btnU3)
        val button_5: Button = findViewById(R.id.btnU5)
        val button_9: Button = findViewById(R.id.btnU9)

        // Functions
        // Resets grades and units to null
        fun resetGradesUnits() {
            grade = null
            units = null
        }

        // Re-enables all buttons
        fun resetButton() {
            if (is_LetterGrade) {
                // Enables Letter Grade Buttons
                button_A.isEnabled = true
                button_BPlus.isEnabled = true
                button_B.isEnabled = true
                button_CPlus.isEnabled = true
                button_C.isEnabled = true
                button_D.isEnabled = true
                button_F.isEnabled = true
            } else {
                // Enables Unit Buttons
                button_3.isEnabled = true
                button_5.isEnabled = true
                button_9.isEnabled = true
            }

            if (grade != null && units != null) button_equal.isEnabled = true
        }

        // If a letter grade has not been pressed, all units buttons will be disabled
        // If a letter grade has been pressed, all units buttons will be enabled and letter grade buttons will be disabled
        fun disableButtons() {
            if (!is_LetterGrade) {
                // Disables Letter Grade Buttons
                button_A.isEnabled = false
                button_BPlus.isEnabled = false
                button_B.isEnabled = false
                button_CPlus.isEnabled = false
                button_C.isEnabled = false
                button_D.isEnabled = false
                button_F.isEnabled = false

            } else {
                // Disables Units Buttons
                button_3.isEnabled = false
                button_5.isEnabled = false
                button_9.isEnabled = false
            }

            if (grade == null || units == null) button_equal.isEnabled = false
            resetButton()
        }

        // Disables buttons on start
        disableButtons()

        fun storeGradesUnits(grade: Double, units: Double) {
            val grade = grade * units
            grades_list.add(grade)
            units_list.add(units)

            this.grade = 0.0
            this.units = 0.0
        }

        fun calcQPI(): Double {
            val total_grades: Double = grades_list.sum()
            val total_units: Double = units_list.sum()
            return total_grades / total_units
        }

        // Click Listeners
        // Click Listeners: Letter Grades
        button_A.setOnClickListener {
            if (!is_SecondGrade) {
                display_equation.append("(A *")
                is_SecondGrade = true
            } else {
                display_equation.append(" + (A *")
            }
            grade = 4.0
            is_LetterGrade = false
            disableButtons()
        }
        button_BPlus.setOnClickListener {
            if (!is_SecondGrade) {
                display_equation.append("(B+ *")
                is_SecondGrade = true
            } else {
                display_equation.append(" + (B+ *")
            }
            grade = 3.5
            is_LetterGrade = false
            disableButtons()
        }
        button_B.setOnClickListener {
            if (!is_SecondGrade) {
                display_equation.append("(B *")
                is_SecondGrade = true
            } else {
                display_equation.append(" + (B *")
            }
            grade = 3.0
            is_LetterGrade = false
            disableButtons()
        }
        button_CPlus.setOnClickListener {
            if (!is_SecondGrade) {
                display_equation.append("(C+ *")
                is_SecondGrade = true
            } else {
                display_equation.append(" + (C+ *")
            }
            grade = 2.5
            is_LetterGrade = false
            disableButtons()
        }
        button_C.setOnClickListener {
            if (!is_SecondGrade) {
                display_equation.append("(C *")
                is_SecondGrade = true
            } else {
                display_equation.append(" + (C *")
            }
            grade = 2.0
            is_LetterGrade = false
            disableButtons()
        }
        button_D.setOnClickListener {
            if (!is_SecondGrade) {
                display_equation.append("(D *")
                is_SecondGrade = true
            } else {
                display_equation.append(" + (D *")
            }
            grade = 1.0
            is_LetterGrade = false
            disableButtons()
        }
        button_F.setOnClickListener {
            if (!is_SecondGrade) {
                display_equation.append("(F *")
                is_SecondGrade = true
            } else {
                display_equation.append(" + (F *")
            }
            grade = 0.0
            is_LetterGrade = false
            disableButtons()
        }

        // Click Listeners: Units
        button_3.setOnClickListener {
            is_LetterGrade = true
            units = 3.0
            display_equation.append(" 3.0)")
            storeGradesUnits(grade!!, units!!)
            disableButtons()
            resetGradesUnits()
        }
        button_5.setOnClickListener {
            is_LetterGrade = true
            units = 5.0
            display_equation.append(" 5.0)")
            storeGradesUnits(grade!!, units!!)
            disableButtons()
            resetGradesUnits()
        }
        button_9.setOnClickListener {
            is_LetterGrade = true
            units = 9.0
            display_equation.append(" 9.0)")
            storeGradesUnits(grade!!, units!!)
            disableButtons()
            resetGradesUnits()
        }

        // Click Listeners: Operations
        button_clear.setOnClickListener {
            // Reset fields to default values
            display_equation.setText("")
            display_qpi.setText("")

            grades_list.clear()
            units_list.clear()
            resetGradesUnits()

            is_LetterGrade = true
            is_SecondGrade = false

            disableButtons()
        }
        button_equal.setOnClickListener {
            val numerator: String = "%.2f".format(grades_list.sum())
            val denominator: String = "%.2f".format(units_list.sum())
            val qpi: String = "%.2f".format(calcQPI())
            display_qpi.setText("$numerator / $denominator = $qpi")

            grades_list.clear()
            units_list.clear()
            resetGradesUnits()

            disableButtons()
        }
    }
}