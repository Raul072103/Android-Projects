package com.raul.myapplication.fake

import com.raul.myapplication.model.AccessInfo
import com.raul.myapplication.model.Authors
import com.raul.myapplication.model.BookInfo
import com.raul.myapplication.model.Epub
import com.raul.myapplication.model.ImageLinks
import com.raul.myapplication.model.ImageLinksBookshelf
import com.raul.myapplication.model.IndustryIdentifier
import com.raul.myapplication.model.Item
import com.raul.myapplication.model.Layer
import com.raul.myapplication.model.LayerInfo
import com.raul.myapplication.model.ListPrice
import com.raul.myapplication.model.Offers
import com.raul.myapplication.model.Pdf
import com.raul.myapplication.model.PenalizationSummary
import com.raul.myapplication.model.Price
import com.raul.myapplication.model.ReadingMode
import com.raul.myapplication.model.RetailPrice
import com.raul.myapplication.model.SaleInfo
import com.raul.myapplication.model.SearchInfo
import com.raul.myapplication.model.VolumeInfo
import com.raul.myapplication.model.VolumeInfoBook

object FakeDataSource {
    val volumeInfo: VolumeInfo = VolumeInfo(
        kind = "books#volume",
        totalItems = 501,
        items = listOf<Item>(
            Item(
                kind = "books#volume",
                id = "J9G50L3c14QC",
                etag = "abc123",
                selfLink = "https://www.googleapis.com/books/v1/volumes/1",
                volumeInfo = Authors(
                    title = "The Fake Book",
                    authors = listOf("Fake Author"),
                    publisher = "Fake Publisher",
                    publishedDate = "2023-01-01",
                    description = "This is a fake book.",
                    industryIdentifiers = listOf(
                        IndustryIdentifier(type = "ISBN_13", identifier = "1234567890123")
                    ),
                    readingModes = ReadingMode(text = true, image = true),
                    pageCount = 200,
                    printType = "BOOK",
                    categories = listOf("Fake Category"),
                    maturityRating = "NOT_MATURE",
                    allowAnonLogging = true,
                    contentVersion = "1.0.0",
                    panelizationSummary = PenalizationSummary(
                        containsEpubBubbles = false,
                        containsImageBubbles = false
                    ),
                    imageLinks = ImageLinksBookshelf(
                        smallThumbnail = "https://example.com/thumbnail",
                        thumbnail = "https://example.com/thumbnail"
                    ),
                    language = "en",
                    previewLink = "https://example.com/preview",
                    infoLink = "https://example.com/info",
                    canonicalVolumeLink = "https://example.com/canonical"
                ),
                saleInfo = SaleInfo(
                    country = "US",
                    saleability = "FOR_SALE",
                    isEbook = true,
                    listPrice = ListPrice(amount = 2.3, currencyCode = "USD"),
                    retailPrice = RetailPrice(amount = 19.99, currencyCode = "USD"),
                    buyLink = "https://example.com/buy",
                    offers = listOf<Offers>(
                        Offers(
                            finskyOfferType = 1,
                            listPrice = Price(amountInMicros = 29990000, currencyCode = "USD"),
                            retailPrice = Price(amountInMicros = 19990000, currencyCode = "USD")
                        )
                    )
                ),
                accessInfo = AccessInfo(
                    country = "US",
                    viewability = "PARTIAL",
                    embeddable = true,
                    publicDomain = false,
                    textToSpeechPermission = "ALLOWED",
                    epub = Epub(isAvailable = true, acsTokenLink = "https://example.com/epub"),
                    pdf = Pdf(isAvailable = true, acsTokenLink = "https://example.com/pdf"),
                    webReaderLink = "https://example.com/reader",
                    accessViewStatus = "SAMPLE",
                    quoteSharingAllowed = false,
                    searchInfo = SearchInfo(textSnippet = "This is a fake book for testing.")
                )
            )
        )
    )


    val bookInfo: BookInfo = BookInfo(
        kind = "books#volume",
        id = "J9G50L3c14QC",
        etag = "tofdENRoUbA",
        selfLink = "https://www.googleapis.com/books/v1/volumes/J9G50L3c14QC",
        volumeInfo = VolumeInfoBook(
            title = "The History of Jazz",
            authors = listOf("Ted Gioia"),
            publisher = "Oxford University Press",
            publishedDate = "2011-05-09",
            description = "Ted Gioia's History of Jazz has been universally hailed as a classic...",
            industryIdentifiers = listOf(
                IndustryIdentifier(type = "ISBN_10", identifier = "0199831874"),
                IndustryIdentifier(type = "ISBN_13", identifier = "9780199831876")
            ),
            readingModes = ReadingMode(text = true, image = true),
            pageCount = 452,
            printedPageCount = 454,
            printType = "BOOK",
            categories = listOf("Music / Genres & Styles / Jazz", "Music / History & Criticism"),
            maturityRating = "NOT_MATURE",
            allowAnonLogging = true,
            contentVersion = "0.11.6.0.preview.3",
            panelizationSummary = PenalizationSummary(
                containsEpubBubbles = false,
                containsImageBubbles = false
            ),
            imageLinks = ImageLinks(
                smallThumbnail = "https://books.google.com/books/content?id=J9G50L3c14QC&printsec=frontcover&img=1&zoom=5&edge=curl&imgtk=AFLRE73ZrPECSv1MZzveWkQf4MY0f5wo8yyOHiO3kaKOsapZSYkYcc5yz20NUgRzIrOviM_CiBepvFPXXEpflVj2_UmQoxdN-tPwsWUnOcjPkdVKVP5T-emrADiQ7Lwd79TPn5uQJNhV&source=gbs_api",
                thumbnail = "https://books.google.com/books/content?id=J9G50L3c14QC&printsec=frontcover&img=1&zoom=1&edge=curl&imgtk=AFLRE72OmnhnjeAL8dC-vzCwq2CwoHzI-YaATxfTY06tgvWXP9zq22t_Nfolt7IFnMThBzdUoZki_7KImxV0jqkTBpRG3w-rk4LYRYDJkeaexSSwBvXJLAdKSRKqTBKH9Esbx3o-MPRxYV&source=gbs_api",
                small = "https://books.google.com/books/content?id=J9G50L3c14QC&printsec=frontcover&img=1&zoom=2&edge=curl&imgtk=AFLRE73tCFi3_qNXbtYUS_UpMZZrbz1XPgSkN_vY94jjrQx_CTqIfZF_-BzuSDw-n0bkgWVLkDma352lGE2cIjSnUIjC356Iye-OzZbMPGs-gc44ae450fJ_DC7ZAWZHr4k0jsMM4PfX&source=gbs_api",
                medium = "https://books.google.com/books/content?id=J9G50L3c14QC&printsec=frontcover&img=1&zoom=3&edge=curl&imgtk=AFLRE71BB4gAgOsOAztRZGBqigQV2vgJBteKReopKj0hU61xkNB7MvH-2XfQuzWMzy0H0FaSt_ctNAHPtYG8fIjhhbEBafzT2sB4fHjNtBNVEJxyTQ1-ljRPBTxGHJgNOl4mwuR9QxYV&source=gbs_api"
            ),
            language = "en",
            previewLink = "http://books.google.ro/books?id=J9G50L3c14QC&hl=&source=gbs_api",
            infoLink = "https://play.google.com/store/books/details?id=J9G50L3c14QC&source=gbs_api",
            canonicalVolumeLink = "https://play.google.com/store/books/details?id=J9G50L3c14QC"
        ),
        layerInfo = LayerInfo(
            layers = listOf(
                Layer(
                    layerId = "geo",
                    volumeAnnotationsVersion = "14"
                )
            )
        ),
        saleInfo = SaleInfo(
            country = "RO",
            saleability = "FOR_SALE",
            isEbook = true,
            listPrice = ListPrice(amount = 64.19, currencyCode = "RON"),
            retailPrice = RetailPrice(amount = 43.65, currencyCode = "RON"),
            buyLink = "https://play.google.com/store/books/details?id=J9G50L3c14QC&rdid=book-J9G50L3c14QC&rdot=1&source=gbs_api",
            offers = listOf(
                Offers(
                    finskyOfferType = 1,
                    listPrice = Price(amountInMicros = 64190000, currencyCode = "RON"),
                    retailPrice = Price(amountInMicros = 43650000, currencyCode = "RON")
                )
            )
        ),
        accessInfo = AccessInfo(
            country = "RO",
            viewability = "PARTIAL",
            embeddable = true,
            publicDomain = false,
            textToSpeechPermission = "ALLOWED",
            epub = Epub(
                isAvailable = true,
                acsTokenLink = "http://books.google.ro/books/download/The_History_of_Jazz-sample-epub.acsm?id=J9G50L3c14QC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api"
            ),
            pdf = Pdf(
                isAvailable = true,
                acsTokenLink = "http://books.google.ro/books/download/The_History_of_Jazz-sample-pdf.acsm?id=J9G50L3c14QC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api"
            ),
            webReaderLink = "http://play.google.com/books/reader?id=J9G50L3c14QC&hl=&source=gbs_api",
            accessViewStatus = "SAMPLE",
            quoteSharingAllowed = false,
            searchInfo = SearchInfo(textSnippet = "Here are the giants of jazz and the great moments of jazz history...")
        )
    )

    var bookUrls: MutableList<String> = mutableListOf(bookInfo.volumeInfo.imageLinks.thumbnail)
}