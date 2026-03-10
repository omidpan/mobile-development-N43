package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helloworld.ui.theme.HelloWorldTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloWorldTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    //01 image
                    MyUIComponentsImage(Modifier.padding(innerPadding))

//                    // 02 Toggle image
//                    ChangeImageWithButton(Modifier.padding(innerPadding))

////                    03 TextField
//                    ShowTextField(Modifier.padding(innerPadding))


//                        //04- combine textField and image
//                    UIExampleImageTextFieldButton(Modifier.padding(innerPadding))

//                     //05 Check box
//                    CheckboxExample()

//                    //06 RadioButtons
//                    RadioButtonsExample()

////                    //07 switch
//                    SwitchExample()

//                    //08 DropDown example
//                    DropDownExample()

                }
            }
        }
    }
}

//01 Image
@Composable
fun MyUIComponentsImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.first_image),

        contentDescription = "Scaled Image",
        modifier = Modifier.size(300.dp),
        contentScale = ContentScale.Fit

    )

}

//02
@Composable
fun ChangeImageWithButton(modifier: Modifier = Modifier) {

    val myImage = remember { mutableStateOf(R.drawable.first_image) }

    Column(modifier = modifier) {

        Button(
            colors=ButtonDefaults.buttonColors(Color.Blue),
            onClick = {
                myImage.value =
                    if (myImage.value == R.drawable.first_image)
                        R.drawable.second_image
                    else
                        R.drawable.first_image
            }
        ) {
            Text("Change Image")
        }

        Image(
            painter = painterResource(id = myImage.value),
            contentDescription = "Dynamic Image"
        )
    }
}

//03 Text field
@Composable
fun ShowTextField(modifier: Modifier = Modifier) {
    /**
     * Better code to move text field in the center of screen
     */
    var textFieldValue = remember { mutableStateOf("Type Here") }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
    {
        TextField(
            value = textFieldValue.value,
            onValueChange = { textFieldValue.value = it },
            label = { Text("Enter your name: ") },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                focusedContainerColor = Color.Black,
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

            )
    }


}

//04 combine
@Composable
fun UIExampleImageTextFieldButton(modifier: Modifier = Modifier) {
    //add default state to start the application
    val myButtonBackgroundColor = remember { mutableStateOf(Color.Red) }
    val myButtonText = remember { mutableStateOf("Do Your Magic") }
    val myButtonTextColor = remember { mutableStateOf(Color.White) }
    val myText = remember { mutableStateOf("Hello World") }
    val myTextColor = remember { mutableStateOf(Color.Black) }
    val buttonStatus = remember { mutableStateOf(true) }
    val valueOnTextField = remember { mutableStateOf("") }
    val userInput = remember { mutableStateOf("Result:") }
    val myImage = remember { mutableStateOf(R.drawable.first_image) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = myImage.value),
            contentDescription = "My Image",
            modifier = Modifier.size(300.dp),
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center
        )
        Spacer(modifier = modifier.size(30.dp))
        if (!buttonStatus.value) {
            Text(
                text = myText.value,
                color = myTextColor.value,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .background(Color.Red)
                    .padding(10.dp)
            )
        }
        Spacer(modifier = modifier.size(30.dp))
        Button(
            onClick = {
                if (buttonStatus.value) {
                    myButtonBackgroundColor.value = Color.Green
                    myButtonText.value = "Magic Done"
                    myButtonTextColor.value = Color.Black
                    myText.value = "Magic Done"
                    myTextColor.value = Color.White
                    myText.value = "Hello Compose"
                    myImage.value = R.drawable.second_image
                    buttonStatus.value = false
                } else {
                    myButtonBackgroundColor.value = Color.Red
                    myButtonText.value = "Do Your Magic"
                    myButtonTextColor.value = Color.White
                    myText.value = "Hello World"
                    myTextColor.value = Color.Black
                    myImage.value = R.drawable.first_image
                    buttonStatus.value = true
                }
                userInput.value = valueOnTextField.value
                valueOnTextField.value = ""
            },
            modifier.size(250.dp, 60.dp),
            colors = ButtonDefaults.buttonColors(myButtonBackgroundColor.value),
            border = BorderStroke(3.dp, Color.Black)
        ) {
            Text(
                text = myButtonText.value,
                color = myButtonTextColor.value,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = modifier.size(30.dp))
        TextField(
            value = valueOnTextField.value,
            onValueChange = { valueOnTextField.value = it },
            label = { Text(text = "Enter your name") },
            modifier = Modifier.width(300.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Red,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.DarkGray,
            ),
            textStyle = TextStyle.Default.copy(fontSize = 20.sp),
            maxLines = 4,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = modifier.size(30.dp))
        Text(
            text = userInput.value,
            color = myTextColor.value,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Red)
                .padding(10.dp)
        )
    }
}

//05 CheckBox
@Composable
fun CheckboxExample(modifier: Modifier = Modifier) {
    val resultText = remember { mutableStateOf("What is your gender?") }
    val maleChecked = remember { mutableStateOf(false) }
    val femaleChecked = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF027CDD)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(150.dp))
        Text(
            text = resultText.value,
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier
                .width(300.dp)
                .background(Color(0xFFAABBCC))
                .padding(vertical = 15.dp),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(30.dp))
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = maleChecked.value,
                    onCheckedChange = {
                        maleChecked.value = it
                        femaleChecked.value = false
                        resultText.value = if (it) "Your gender is Male" else "What is your gender?"
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Green,
                        uncheckedColor = Color.White
                    )
                )
                Text("Male", fontSize = 20.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = femaleChecked.value,
                    onCheckedChange = {
                        femaleChecked.value = it
                        maleChecked.value = false
                        resultText.value =
                            if (it) "Your gender is Female" else "What is your gender?"
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Green,
                        uncheckedColor = Color.White
                    )
                )
                Text("Female", fontSize = 20.sp, color = Color.White)
            }
        }
    }
}

//06 Radio Button

@Composable
fun RadioButtonsExample(modifier: Modifier = Modifier) {
    val backgroundColor = remember { mutableStateOf(Color.White) }
    val selectedOptionIndex = remember { mutableStateOf(0) }
    val colorOptions = listOf("Red", "Green", "Yellow", "Gray")
    val colorValues = listOf(Color.Red, Color.Green, Color.Yellow, Color.Gray)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor.value),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Select a Color:",
            fontSize = 24.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))
        Column {
            colorOptions.forEachIndexed { index, colorName ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = index == selectedOptionIndex.value,
                        onClick = { selectedOptionIndex.value = index }
                    )
                    Text(text = colorName, fontSize = 20.sp, color = Color.Black)
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = { backgroundColor.value = colorValues[selectedOptionIndex.value] }
        ) {
            Text(text = "Change Background Color")
        }
    }
}

//07 Switch
@Composable
fun SwitchExample(modifier: Modifier = Modifier) {
    //default state for toggle switch
    val switchState = remember { mutableStateOf(false) }
    val myText = remember { mutableStateOf("The image is visible") }
    val myAlphaValue = remember { mutableStateOf(1F) }
    //create a column to add UI Components to them
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Switch(
            checked = switchState.value,
            onCheckedChange = { switchState.value = it },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Blue,
                checkedTrackColor = Color.Red,
                uncheckedThumbColor = Color.Red,
                uncheckedTrackColor = Color.Blue
            )
        )
        Spacer(modifier = Modifier.height(30.dp))
        if (!switchState.value) {
            myText.value = "The image is visible"
            myAlphaValue.value = 1F
        } else {
            myText.value = "The image is invisible"
            myAlphaValue.value = 0F
        }
        Image(
            painter = painterResource(id = R.drawable.first_image),
            contentDescription = "My Image",
            modifier = Modifier
                .size(300.dp)
                .alpha(myAlphaValue.value)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = myText.value,
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier
                .background(Color.Blue)
                .width(300.dp)
                .padding(vertical = 10.dp),
            textAlign = TextAlign.Center
        )
    }
}

//08 DropDown example
@Composable
fun DropDownExample(modifier: Modifier = Modifier) {
    val dropDownStatus = remember { mutableStateOf(false) }
    val itemPosition = remember { mutableStateOf(0) }
    val countryList = listOf("Germany", "France", "Spain", "Italy", "United Kingdom")
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable { dropDownStatus.value = true }
            ) {
                Text(
                    text = countryList[itemPosition.value],
                    fontSize = 20.sp,
                )
                Image(
                    painter = painterResource(id = R.drawable.drop_down_icon),
                    contentDescription = ""
                )
            }
            DropdownMenu(
                expanded = dropDownStatus.value,
                onDismissRequest = { dropDownStatus.value = false }
            ) {
                countryList.forEachIndexed { index, country ->
                    DropdownMenuItem(
                        text = { Text(text = country) },
                        onClick = {
                            itemPosition.value = index
                            dropDownStatus.value = false
                        }
                    )
                }
            }
        }
    }
}


@Preview(
    showBackground = true, showSystemUi = true,
    device = "spec:width=300dp,height=500dp,dpi=200"
)
@Composable
fun Preview() {
    HelloWorldTheme {
//        MyUIComponentsImage()
//        ChangeImageWithButton()
//        UIExampleImageTextFieldButton()
//            CheckboxExample()
//        RadioButtonsExample()
//        SwitchExample()
        DropDownExample()
    }
}
