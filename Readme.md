# PetFood

Petfood is a mobile app, that helps its users to properly feed their pets. For now planned functionality is to allow users easily determine which food is safe to a pet, and in which quantities.

Despite the name, currently we are not focusing on all sorts and breeds of animals. We are focusing on rabbits only. And also we are planning only Android app, because we have competencies only in that. 

Similar apps:
- [Cat Dog Eat](https://play.google.com/store/apps/details?id=com.quagtech.candogseat.app&hl=en&gl=US)
- [PAWSM — Dog nutrition](https://play.google.com/store/apps/details?id=com.pawsm.mobile)
- [NutriPup](https://play.google.com/store/apps/details?id=com.nextgen.feedemsmart)

# Sprint 2

At this sprint our goal was to make our android application to be able to operate over network with some backend. Our tasks were: Create some backend, capable of returning food info, with some authentication mechanism (see #21), Design UI(#23), and update android app to conform backend(#22). 
Also we set up CI/CD for android app, which just builds an app for now (and makes sure, that it builds successfully). Result of build -- **ready APK** -- is also generated and available for download

We made a progress on US #3 and #17, but haven't completed them, since they are large (and we didn't plan it). For now, there were no sprint review with PO, so we don't close any issues yet. 

We setup automatic generation of Kotlin docs with Dokka, but without CI/CD yet.
Docs for code in `master` are available [here](https://drive.google.com/file/d/1aKPRUFoc7iDrqWjkPv2SnEDMkkhc3-G0/view?usp=sharing).

Unfortunately, the tests are weakest part of our work: we haven't any neither for Android app, nor for server.