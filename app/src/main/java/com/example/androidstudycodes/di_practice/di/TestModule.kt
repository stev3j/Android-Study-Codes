package com.example.androidstudycodes.di_practice.di


//@Module
//@InstallIn(SingletonComponent::class)
object TestModule {

//    @Singleton
//    @Provides
    fun provideTestString() = "테스트 텍스트가 주입되었습니다."

}