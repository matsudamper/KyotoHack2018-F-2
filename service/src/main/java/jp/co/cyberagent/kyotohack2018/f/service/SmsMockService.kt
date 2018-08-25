package jp.co.cyberagent.kyotohack2018.f.service

import io.reactivex.processors.BehaviorProcessor
import jp.co.cyberagent.kyotohack2018.f.model.Article
import jp.co.cyberagent.kyotohack2018.f.model.HomeContent
import jp.co.cyberagent.kyotohack2018.f.model.Myself
import jp.co.cyberagent.kyotohack2018.f.model.category.Category
import jp.co.cyberagent.kyotohack2018.f.model.category.RootCategory
import jp.co.cyberagent.kyotohack2018.f.model.company.Company
import jp.co.cyberagent.kyotohack2018.f.model.company.CompanyCard
import jp.co.cyberagent.kyotohack2018.f.model.content.Content
import jp.co.cyberagent.kyotohack2018.f.model.content.ContentCard
import java.util.*

class SmsMockService : SmsService {
    override fun getHomeContent() = BehaviorProcessor.create<HomeContent>().apply {
        onNext(HomeContent(
                banners = mockContentCardList(),
                histories = mockContentCardList(),
                newContent = mockContentCardList(),
                rankings = mockContentCardList()
        ))
    }

    override fun getCategories() = BehaviorProcessor.create<List<Category>>().apply {

    }

    override fun getContentArticle(page: Long) = BehaviorProcessor.create<List<Article>>().apply {

    }

    override fun getMyUser() = BehaviorProcessor.create<Myself>().apply {

    }

    override fun getContent(id: Long) = BehaviorProcessor.create<Content>().apply {

    }

    override fun getCompany(id: Long) = BehaviorProcessor.create<Company>().apply {

    }

    override fun searchContent(categoryId: List<List<Long>>, page: Int) = BehaviorProcessor.create<List<Content>>().apply {

    }

    private fun mockContentCardList() = mutableListOf<ContentCard>().apply {
        (0..10).forEach {
            add(ContentCard(
                    id = 1,
                    title = "タイトル",
                    description = "説明",
                    author = "登壇者",
                    thumbnail = "https://image.slidesharecdn.com/20120927kwappa-120926230302-phpapp02/95/lt-1-728.jpg?cb=1348700775",
                    isBookMarked = false,
                    createAt = Calendar.getInstance().timeInMillis,
                    categories = mutableListOf<RootCategory>().apply {
                        add(RootCategory(0, "言語", mutableListOf<Category>().apply {
                            add(Category(1, "Kotlin"))
                        }))
                        add(RootCategory(0, "プラットフォーム", mutableListOf<Category>().apply {
                            add(Category(1, "Android"))
                            add(Category(1, "Native"))
                        }))
                    },
                    company = CompanyCard(
                            id = 1,
                            thumbnail = "https://image.slidesharecdn.com/20120927kwappa-120926230302-phpapp02/95/lt-1-728.jpg?cb=1348700775",
                            description = "説明",
                            name = "会社名",
                            address = "住所",
                            url = "http://google.com"
                    )

            ))
        }
    }
}