// Öğrencinin maksimum ders kayıt sayısını kontrol etmek için bir değişken
const MAX_COURSES = 5;

// Öğrencinin mevcut kayıtlı ders sayısını takip etmek için bir değişken
let currentCourseCount = 0;

// Zorunlu dersler
const mandatoryCourses = ["Matematik", "Bilgisayar", "Fizik"];

// Batch verilerini çek
async function fetchBatches() {
    try {
        const response = await fetch('http://localhost:8081/api/v1/batch/getAllBatches');

        if (!response.ok) {
            throw new Error('Ağ sorunu: ' + response.statusText);
        }

        const batches = await response.json();
        console.log('Ders Grupları:', batches);

        if (!Array.isArray(batches) || batches.length === 0) {
            alert('Batch bulunamadı.');
            return;
        }

        const batchSelect = document.getElementById('courseSelect');
        batchSelect.innerHTML = '<option value="" disabled selected>Ders Seçin</option>';

        batches.forEach(batch => {
            const option = document.createElement('option');
            option.value = batch.batchid;
            option.textContent = batch.batchname;
            batchSelect.appendChild(option);
        });
    } catch (error) {
        console.error('Error fetching batches:', error);
        alert('Batch listesi yüklenirken bir hata oluştu.');
    }
}

// Öğrenci detaylarını çek
async function fetchStudentDetails() {
    const studentId = document.getElementById('studentId').value;
    if (!studentId) {
        showMessage('Lütfen geçerli bir öğrenci ID girin.', 'danger');
        return;
    }

    try {
        const response = await fetch(`http://localhost:8081/api/v1/student/${studentId}`);

        if (response.status === 204) {
            document.getElementById('noRecordsMessage').style.display = 'block';
            document.getElementById('studentInfo').style.display = 'none';
            return;
        } else if (!response.ok) {
            showMessage('Bir hata oluştu: ' + response.statusText, 'danger');
            return;
        }

        const studentDetails = await response.json();
        const studentInfoContent = document.getElementById('studentInfoContent');
        studentInfoContent.innerHTML = '';

        const infoRow = document.createElement('div');
        infoRow.classList.add('row', 'info-row');
        infoRow.innerHTML = `
            <div class="col-md-6">
                <strong>Öğrenci ID:</strong> ${studentDetails.studentId}
            </div>
            <div class="col-md-6">
                <strong>Öğrenci Adı:</strong> ${studentDetails.studentName}
            </div>
            <div class="col-md-6">
                <strong>Adres:</strong> ${studentDetails.address}
            </div>
            <div class="col-md-6">
                <strong>Telefon:</strong> ${studentDetails.phone}
            </div>
        `;
        studentInfoContent.appendChild(infoRow);

        document.getElementById('studentInfo').style.display = 'block';

        // Zorunlu dersleri her zaman burada göster
        displayMandatoryCourses();

        fetchEnrollments(); // Öğrenci enrollments'ını da getir

    } catch (error) {
        console.error('Error fetching student details:', error);
        showMessage('Bir hata oluştu. Lütfen tekrar deneyin.', 'danger');
    }
}

// Zorunlu dersleri ekleyen fonksiyon
function displayMandatoryCourses() {
    const mandatoryCoursesList = document.getElementById('mandatoryCoursesList');
    mandatoryCoursesList.innerHTML = ''; // Listeyi temizle

    mandatoryCourses.forEach(course => {
        const listItem = document.createElement('li');
        listItem.textContent = course;
        mandatoryCoursesList.appendChild(listItem);
    });
}

// Ders kayıtlarını çek
async function fetchEnrollments() {
    const studentId = document.getElementById('studentId').value;
    if (!studentId) {
        showMessage('Lütfen geçerli bir öğrenci ID girin.', 'danger');
        return;
    }

    try {
        const response = await fetch(`http://localhost:8081/api/v1/enrollment/getStudentEnrollments/${studentId}`);

        if (response.status === 204) {
            showMessage('Hiç kayıtlı ders bulunamadı.', 'info');
            document.getElementById('enrollmentsInfo').style.display = 'none';
            document.getElementById('newEnrollmentForm').style.display = 'block';
            return;
        }

        const enrollments = await response.json();

        console.log('Kayıtlar:', enrollments);

        const enrollmentsInfoContent = document.getElementById('enrollmentsInfoContent');
        enrollmentsInfoContent.innerHTML = '';

        if (Array.isArray(enrollments) && enrollments.length > 0) {
            currentCourseCount = enrollments.length;

            enrollments.forEach(enrollment => {
                const infoRow = document.createElement('div');
                infoRow.classList.add('row', 'info-row');
                infoRow.innerHTML = `
                    <div class="col-md-6">
                        <strong>Ders Adı:</strong> ${enrollment.batchName}
                    </div>
                    <div class="col-md-6">
                        <strong>Kayıt Id:</strong> ${enrollment.enrollid}
                    </div>
                    <div class="col-md-6">
                        <strong>Katılım Tarihi:</strong> ${enrollment.joindate}
                    </div>
                    <div class="col-md-6">
                        <button class="btn btn-danger" onclick="deleteEnrollment(${enrollment.enrollid})">Sil</button>
                    </div>
                `;
                enrollmentsInfoContent.appendChild(infoRow);
            });

            document.getElementById('enrollmentsInfo').style.display = 'block';
        } else {
            showMessage('Hiç kayıtlı ders bulunamadı.', 'info');
        }

        document.getElementById('newEnrollmentForm').style.display = 'block';

    } catch (error) {
        console.error('Error fetching enrollments:', error);
        showMessage('Bir hata oluştu. Lütfen tekrar deneyin.', 'danger');
    }
}

// Ders kaydı yap
document.getElementById('enrollmentForm').addEventListener('submit', async (e) => {
    e.preventDefault();
    const studentId = document.getElementById('studentId').value;
    const batchId = document.getElementById('courseSelect').value;

    if (!studentId || !batchId) {
        showMessage('Lütfen tüm alanları doldurun.', 'warning');
        return;
    }

    if (currentCourseCount >= MAX_COURSES) {
        showMessage('Maksimum 5 ders seçebilirsiniz.', 'warning');
        return;
    }

    try {
        const response = await fetch(`http://localhost:8081/api/v1/enrollment/save`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                student_id: studentId,
                batch_id: batchId,
                joindate: new Date().toISOString().split('T')[0],
                fee: 350
            })
        });

        if (response.ok) {
            showMessage('Ders kaydınız başarıyla yapıldı!', 'success');
            currentCourseCount++;
        } else {
            const errorText = await response.text();
            showMessage('Ders kaydı yapılırken bir hata oluştu: ' + errorText, 'danger');
        }
    } catch (error) {
        console.error('Error enrolling in course:', error);
        showMessage('Bir hata oluştu. Lütfen tekrar deneyin.', 'danger');
    }
});

// Kayıt silme fonksiyonu
async function deleteEnrollment(enrollId) {
    try {
        const response = await fetch(`http://localhost:8081/api/v1/enrollment/delete/${enrollId}`, {
            method: 'DELETE',
        });

        if (response.ok) {
            showMessage('Kayıt başarıyla silindi.', 'success');
            currentCourseCount--; // Ders kaydını sildikten sonra mevcut ders sayısını güncelle
            fetchEnrollments(); // Kayıtlar listesini yeniden yükle
        } else {
            const errorText = await response.text();
            showMessage('Kayıt silinirken bir hata oluştu: ' + errorText, 'danger');
        }
    } catch (error) {
        console.error('Error deleting enrollment:', error);
        showMessage('Bir hata oluştu. Lütfen tekrar deneyin.', 'danger');
    }
}

// Sayfa yüklendiğinde ders gruplarını ve gerekli verileri çek
window.onload = function () {
    fetchBatches();
};

// Geribildirim mesajları göstermek için yardımcı fonksiyon
function showMessage(message, type) {
    const messageContainer = document.getElementById('messageContainer');
    messageContainer.innerHTML = `<div class="alert alert-${type}" role="alert">${message}</div>`;
}

// Geri dön butonu
function goBack() {
    document.getElementById('studentInfo').style.display = 'none';
    document.getElementById('enrollmentsInfo').style.display = 'none';
    document.getElementById('newEnrollmentForm').style.display = 'none';
}
