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
import jp.co.cyberagent.kyotohack2018.f.model.event.Event
import jp.co.cyberagent.kyotohack2018.f.model.event.EventCard
import java.util.*

class SmsMockService : SmsService {
    override fun getHomeContent() = BehaviorProcessor.create<HomeContent>().apply {
        onNext(HomeContent(
                banners = mockContentCardList(),
                events = mockEventCardList(),
                histories = mockContentCardList(),
                newContent = mockContentCardList(),
                rankings = mockContentCardList()
        ))
    }

    override fun getCategories() = BehaviorProcessor.create<List<RootCategory>>().apply {
        onNext(mockCategories())
    }

    override fun getContentArticle(page: Long) = BehaviorProcessor.create<List<Article>>().apply {
        onNext(mockArticleList())
    }

    override fun getMyUser() = BehaviorProcessor.create<Myself>().apply {
        onNext(mockMyUser())
    }

    override fun getContent(id: Long) = BehaviorProcessor.create<Content>().apply {
        onNext(mockContent())
    }

    override fun getCompany(id: Long) = BehaviorProcessor.create<Company>().apply {
        onNext(mockCompany())
    }

    override fun getEvent(id: Long) = BehaviorProcessor.create<Event>().apply {
        onNext(mockEvent())
    }

    override fun searchContentCard(categoryId: List<List<Long>>, page: Int) = BehaviorProcessor.create<List<ContentCard>>().apply {
        onNext(mockContentCardList())
    }

    private fun mockContent() = Content(
            id = 1,
            title = "タイトル",
            description = "説明",
            author = "登壇者",
            thumbnail = "https://image.slidesharecdn.com/20120927kwappa-120926230302-phpapp02/95/lt-1-728.jpg?cb=1348700775",
            isBookMarked = false,
            createAt = Calendar.getInstance().timeInMillis,
            categories = mockCategories(),
            company = mockCompaneyCard(),
            timeMap = null,
            slideUrls = null,
            movieUrl = "https://www.youtube.com/watch?v=dE7T_ssiOvE"
    )

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
                    categories = mockCategories(),
                    company = mockCompaneyCard()

            ))
        }
    }

    private fun mockCategories() = mutableListOf<RootCategory>().apply {
        add(RootCategory(0, "言語", mutableListOf<Category>().apply {
            add(Category(1, "Kotlin"))
        }))
        add(RootCategory(0, "プラットフォーム", mutableListOf<Category>().apply {
            add(Category(1, "Android"))
            add(Category(1, "Native"))
        }))
    }

    private fun mockCompany() = Company(
            id = 1,
            thumbnail = "https://image.slidesharecdn.com/20120927kwappa-120926230302-phpapp02/95/lt-1-728.jpg?cb=1348700775",
            description = "説明",
            name = "会社名",
            address = "住所",
            url = "http://google.com",
            events = mockEventCardList(),
            topEvent = mockEventCard()
    )

    private fun mockCompaneyCard() = CompanyCard(
            id = 1,
            thumbnail = "https://image.slidesharecdn.com/20120927kwappa-120926230302-phpapp02/95/lt-1-728.jpg?cb=1348700775",
            description = "説明",
            name = "会社名",
            address = "住所",
            url = "http://google.com"
    )

    private fun mockArticle() = Article(
            id = 10,
            title = "投稿タイトル",
            url = "http://google.com",
            thumbnail = "https://image.slidesharecdn.com/20120927kwappa-120926230302-phpapp02/95/lt-1-728.jpg?cb=1348700775",
            description = "",
            contentId = 10
    )

    private fun mockArticleList() = mutableListOf<Article>().apply { (0..20).forEach { add(mockArticle()) } }

    private fun mockEventCardList() = mutableListOf<EventCard>().apply { (0..20).forEach { add(mockEventCard()) } }

    private fun mockEventCard() = EventCard(
            id = 100,
            description = "イベント説明",
            title = "イベントタイトル",
            companyCard = mockCompaneyCard(),
            thumbnail = "https://connpass-tokyo.s3.amazonaws.com/thumbs/a8/2f/a82f1b8ac1704680cdaae58b4356bec6.png"
    )

    private fun mockEvent() = Event(
            id = 100,
            description = "イベント説明",
            title = "イベントタイトル",
            companyCard = mockCompaneyCard(),
            thumbnail = "https://connpass-tokyo.s3.amazonaws.com/thumbs/a8/2f/a82f1b8ac1704680cdaae58b4356bec6.png",
            content = mockContentCardList()
    )

    private fun mockMyUser() = Myself(
            id = 10,
            createAt = Calendar.getInstance().timeInMillis,
            name = "私だ",
            posts = mockArticleList()
    )
}