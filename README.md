# BaseApplication
tạo thư viện base app


# Step 1: Add it in your root build.gradle: (Project) at the end of repositories
allprojects {
  repositories {
    ...
maven { url 'https://jitpack.io' }
  }
}
# Step 2: Add the dependency in build.gradle (Module:app)
dependencies {
  ...
implementation 'com.github.duong-nk:BaseApplication:Tag'
}
