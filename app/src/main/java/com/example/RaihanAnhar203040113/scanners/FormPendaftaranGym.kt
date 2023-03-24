package com.example.RaihanAnhar203040113.scanners

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.benasher44.uuid.uuid4
import com.example.RaihanAnhar203040113.model.PendaftaranAwal
import com.example.RaihanAnhar203040113.persistences.PendaftaranAwalDao
import com.example.RaihanAnhar203040113.ui.theme.Purple700
import com.example.RaihanAnhar203040113.ui.theme.Teal200
import kotlinx.coroutines.launch

@Composable
fun FormPendaftaranGym(pendaftaranAwalDao: PendaftaranAwalDao) {
    val scope = rememberCoroutineScope()
    val idmember = remember{mutableStateOf(TextFieldValue(""))}
    val nama = remember { mutableStateOf(TextFieldValue("")) }
    val tempatLahir = remember { mutableStateOf(TextFieldValue("")) }
    val tglLahir = remember{ mutableStateOf(TextFieldValue("")) }
    val alamat = remember { mutableStateOf(TextFieldValue("")) }
    val noHp = remember { mutableStateOf(TextFieldValue("")) }

    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {
        OutlinedTextField(label = { Text(text = "ID")}, value = idmember.value, onValueChange = {idmember.value = it},
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Characters, keyboardType = KeyboardType.Number),
        placeholder = { Text(text = "ID")}
        )

        OutlinedTextField(label = { Text(text = "Nama")}, value = nama.value , onValueChange = {nama.value = it},
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
        placeholder = { Text(text = "Your Name")}
        )

        OutlinedTextField(label = { Text(text = "Tempat Lahir")}, value = tempatLahir.value , onValueChange = {tempatLahir.value = it},
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "XXXX")}
        )

        OutlinedTextField(label = { Text(text = "Tanggal Lahir")}, value = tglLahir.value , onValueChange = {tglLahir.value = it},
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            placeholder = { Text(text = "yyyy-mm-dd")}
        )

        OutlinedTextField(label = { Text(text = "Alamat")}, value = alamat.value , onValueChange = {alamat.value = it},
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "Address")}
        )

        OutlinedTextField(label = { Text(text = "Nomor HP")}, value = noHp.value , onValueChange = {noHp.value = it},
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Characters, keyboardType = KeyboardType.Number),
            placeholder = { Text(text = "Number HP")}
        )

        val loginButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Purple700,
            contentColor = Teal200
        )

        val resetButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Teal200,
            contentColor = Purple700
        )

        Row (modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()) {
            Button(modifier = Modifier.weight(5f), onClick = {
                val id = uuid4().toString()
                val item = PendaftaranAwal(id, idmember.value.text, nama.value.text, tempatLahir.value.text, tglLahir.value.text, alamat.value.text, noHp.value.text)
                scope.launch { pendaftaranAwalDao.insertAll(item) }
                idmember.value = TextFieldValue("")
                nama.value = TextFieldValue("")
                tempatLahir.value = TextFieldValue("")
                tglLahir.value = TextFieldValue("")
                alamat.value = TextFieldValue("")
                noHp.value = TextFieldValue("")
            },
            colors = loginButtonColors) {
                Text(text = "Simpan", style = TextStyle(color = Color.White, fontSize = 18.sp), modifier = Modifier.padding(8.dp))
            }
            Button(modifier = Modifier.weight(5f), onClick = {
                idmember.value = TextFieldValue("")
                nama.value = TextFieldValue("")
                tempatLahir.value = TextFieldValue("")
                tglLahir.value = TextFieldValue("")
                alamat.value = TextFieldValue("")
                noHp.value = TextFieldValue("")
            },
                colors = resetButtonColors) {
                Text(text = "Reset", style = TextStyle(color = Color.White, fontSize = 18.sp), modifier = Modifier.padding(8.dp))
            }
        }
    }
}