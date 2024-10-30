package com.example.week5

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun LatihanUserInput(modifier: Modifier = Modifier) {

    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var nohp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    var datanama by remember { mutableStateOf("") }
    var dataemail by remember { mutableStateOf("") }
    var datanohp by remember { mutableStateOf("") }
    var dataalamat by remember { mutableStateOf("") }

    var jeniskelamin by remember { mutableStateOf("") }
    var datajeniskelamin by remember { mutableStateOf("") }
    val datajk = listOf("Laki-laki", "Perempuan")

    Column (modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Text("BIODATA",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp)
        Spacer(modifier = Modifier.padding(20.dp))
        TextField(
            value = nama,
            onValueChange = {nama = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text("Nama") },
            placeholder = {
                Text("Masukan Nama Anda!", color = Color.Gray)
            }
        )
        Row {
            datajk.forEach{selectedJK ->
            Row (verticalAlignment = Alignment.CenterVertically){
                RadioButton(selected = jeniskelamin == selectedJK,
                    onClick = {
                        jeniskelamin = selectedJK
                    })
                    Text(selectedJK)
                }
            }
        }

        TextField(
            value = email,
            onValueChange = {email = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text("Email") },
            placeholder = {
                Text("Masukan Email Anda!", color = Color.Gray)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        TextField(
            value = nohp,
            onValueChange = {nohp = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text("No Handphone") },
            placeholder = {
                Text("Masukan No HP Anda!", color = Color.Gray)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        TextField(
            value = alamat,
            onValueChange = {alamat = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text("Alamat") },
            placeholder = {
                Text("Masukan Alamat Anda!", color = Color.Gray)
            }
        )

        Button(onClick = {
            datanama = nama
            datajeniskelamin = jeniskelamin
            dataemail = email
            datanohp = nohp
            dataalamat = alamat
                         }, modifier = Modifier.padding(vertical = 10.dp)) {
            Text("Submit")
        }
        Card(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Column {
                TampilData(
                    judul = "Nama",
                    isinya = datanama
                )
                TampilData(
                    judul = "JK",
                    isinya = datajeniskelamin
                )
                TampilData(
                    judul = "Email",
                    isinya = dataemail
                )
                TampilData(
                    judul = "No HP",
                    isinya = datanohp
                )
                TampilData(
                    judul = "Alamat",
                    isinya = dataalamat
                )
            }
        }
    }
}

@Composable
fun TampilData(
    judul:String,
    isinya:String
){
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween){
        Text(judul, modifier = Modifier.weight(0.8f))
        Text(":", modifier = Modifier.weight(0.2f))
        Text(isinya, modifier = Modifier.weight(2f))
    }
}
