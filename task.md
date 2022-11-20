1. Tambahkan method untuk update data user => put mapping  
   Dengan kriteria, user bisa mengupdate atribut di detailnya, firstName, lastName, phoneNumber
2. Lengkapi validasinya, dari servicenya
3. API untuk peminjaman
   1. POST => borrow
   2. POST => return
   3. Entity : PeminjamanBuku
      1. id
      2. user => many to one ke User
      3. book => many to one ke Book
      4. createdAt => tanggal peminjaman
      5. updatedAt => tanggal kembalinya
DEADLINE => Senin, 21 Nov 2022, 1 jam sebelum kelas.