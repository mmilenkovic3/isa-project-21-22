# isa-project-21-22

Autor: Maja Milenkovic RA 96/2017
       Student 1        
       
Mejlovi korisnika (mejlovi su kreirani za potrebe proslog projekta 19/20)

ADMIN (ID 1) pharmacistpharmacy33@gmail.com (lozinka email-a:  pharmacist*1)

USER (ID 2): patient0874@gmail.com (lozinka email-a: patient98)

Napomena: 
  1. Prilikom testiranja slanje emaila, potrebno je onesposobiti avast.
  2. https://myaccount.google.com/lesssecureapps?pli=1&rapt=AEjHL4MsInjIYwcSZC-USbz9it79qaL-rdDHdgfF7ZTA-cW2utOfhBDNmfs-JqI2XFEgC8QTiInfGX_hAQH0OQ6awC-GBVMUjQ 
     potrebno je iskljuci ovu opciju ukoliko se registrujete sa nekim Vašim, ili novim mejlom.
  3. Svakom korisniku su u bazi se pristupa sa lozinkom: 123


Tehnologije: 

       1. Backend: Java + Spring Boot
       
       2. Frontend: Vue.js + Axios 
       
       3. RDBMS: MySQL
       
Front-end instalacije:

       1. Node JS
       
       2. Vue JS
       
       3. Praćen sledeći snimak za instalaciju:  https://www.youtube.com/watch?v=Wy9q22isx3U (od 7:20 minuta)

Back-end instalacije:

       1. Skinuti i instalirati intellij (https://www.jetbrains.com/idea/download/#section=windows)        


Uputsvo za pokretanje:

Front-end: 

       - pozicionirati se u CommandPromptu na folder isa-projekt-21-22/frontend'isa21-22
       
       - ili otvoriti taj isti folder u Visual Studio code
       
       - npm install
       
       - npm run serve
       
       - port frontenda: 3000 (Promena porta se vrsi u frontend'isa21-22/vue.config.js fajlu
       
Back-end:

       - File -> Open -> Izabrati folder isa-projekt-21-22/isa21-22
       
       - Desni klik na projekat -> Open module settings -> podesiti SDKs ( Koristila sam jdk-11.0.12 )
       
       - Add configuration -> Izabrati + -> Application -> izabrati isti SKDs 
       
       - kao Main class-u izabrati com.example.isa212.Application
       
       - gore desno ima MAVEN -> install
       
       - i pokrenuti aplikaciju
       
       - port backend-a: 8083

Baza:

       - Ne radi spring hibernaet automatsko popujavanje,
       
       - Potrebno je koristiti MySQL Workbench 8.0 CE 
       
       - pokrenuti skripte SHCEMA.sql da bi se podaci popunili.
       
              Username: root,              
              Password: root


Dodatno:

Prilikom testiranja aplikacije, prilikom klikna na dugmice, potrebno je sacekati par sekundi da bi aplikacija obavila posa. :)
      
       
       
