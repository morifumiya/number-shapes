package rob.myappcompany.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {
        int number;

        public boolean isSquare() {

            double squareRoot = Math.sqrt(number);

            if (squareRoot == Math.floor(squareRoot)) {
                return true;

            } else {
                return false;
            }


        }

        public boolean isTriangular() {

            int x = 1;

            int triangularNumber = 1;

            while (triangularNumber < number) {

                x++;

                triangularNumber = triangularNumber + x;
            }

            if (triangularNumber == number) {
                return true;
            } else {
                return false;
            }
        }

    }

    public void testNumber(View view) {

        Log.i("info", "button pressed");

        EditText editText = (EditText) findViewById(R.id.editTextNumber);

        String message;

        if (editText.getText().toString().isEmpty()) {

            message = "数値を入れて決定を押してください";

        } else {

            Number myNumber = new Number();

            myNumber.number = Integer.parseInt(editText.getText().toString());

            message = editText.getText().toString();
            if (myNumber.isSquare() && myNumber.isTriangular()) {

                message += " は、四角形、または三角形だね！";

            } else if (myNumber.isSquare()) {

                message += " は、四角形であり、三角形ではない！";

            } else if (myNumber.isTriangular()) {

                message += " は、三角形であり、四角形ではない！";

            } else {

                message += " は、三角形でも四角形でもない！";

            }

        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
