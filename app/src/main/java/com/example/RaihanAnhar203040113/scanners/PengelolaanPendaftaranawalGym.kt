package com.example.RaihanAnhar203040113.scanners

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.RaihanAnhar203040113.model.PendaftaranAwal
import com.example.RaihanAnhar203040113.persistences.AppDatabase
import com.example.RaihanAnhar203040113.persistences.PendaftaranAwalDao


@Composable
fun PengelolaanPendaftaranawalGym() {
    val context = LocalContext.current
    val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "pengelolaan-pendaftaran awal Gym"
    ).build()
    val pendaftaranAwalDao = db.pendaftaranAwalDao()
    val list : LiveData<List<PendaftaranAwal>> = pendaftaranAwalDao.loadAll()
    val items: List<PendaftaranAwal> by list.observeAsState(initial = listOf())
    Column(modifier = Modifier.fillMaxWidth()) {
        FormPendaftaranawalGym (pendaftaranAwalDao)
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items = items, itemContent = { item ->
                Row(modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()) {
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "ID", fontSize = 14.sp)
                        Text(text = item.idmember, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Nama", fontSize = 14.sp)
                        Text(text = item.nama, fontSize = 16.sp, fontWeight =
                        FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Tempat Lahir", fontSize = 14.sp)
                        Text(text = item.tempatLahir, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Tanggal Lahir", fontSize = 14.sp)
                        Text(text = item.tglLahir, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "ALamat", fontSize = 14.sp)
                        Text(text = item.alamat, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "No HP", fontSize = 14.sp)
                        Text(text = item.noHp, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                }
                Divider(modifier = Modifier.fillMaxWidth())
            })
        }
    }
}

@Composable
fun FormPendaftaranawalGym(pendaftaranAwalDao: PendaftaranAwalDao) {

}
