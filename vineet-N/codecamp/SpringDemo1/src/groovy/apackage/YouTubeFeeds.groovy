package apackage
/*
package my.company

import com.google.gdata.client.youtube.YouTubeService
import com.google.gdata.data.youtube.VideoEntry
import com.google.gdata.data.youtube.YouTubeMediaRating
import com.google.gdata.data.youtube.YouTubeMediaContent
import com.google.gdata.data.youtube.YtStatistics
import com.google.gdata.data.youtube.YouTubeMediaGroup
import com.google.gdata.data.youtube.YtPublicationState

*/
/**
 * Created with IntelliJ IDEA.
 * User: mohit
 * Date: 30/7/12
 * Time: 2:31 PM
 * To change this template use File | Settings | File Templates.
 *//*

class YouTubeDataFetch {
    public void commentYouTubeFeeds(){
       YouTubeService youTubeService = new YouTubeService();
        String videoEntryUrl = "http://gdata.youtube.com/feeds/api/videos/LOlcpr7qEv4";
        VideoEntry videoEntry = youTubeService.getEntry(new URL(videoEntryUrl), VideoEntry.class);
        printVideoEntry(videoEntry, true);
    }

    public static void printVideoEntry(VideoEntry videoEntry, boolean detailed) {
        System.out.println("Title: " + videoEntry.getTitle().getPlainText());

        if(videoEntry.isDraft()) {
            System.out.println("Video is not live");
            YtPublicationState pubState = videoEntry.getPublicationState();
            if(pubState.getState() == YtPublicationState.State.PROCESSING) {
                System.out.println("Video is still being processed.");
            }
            else if(pubState.getState() == YtPublicationState.State.REJECTED) {
                System.out.print("Video has been rejected because: ");
                System.out.println(pubState.getDescription());
                System.out.print("For help visit: ");
                System.out.println(pubState.getHelpUrl());
            }
            else if(pubState.getState() == YtPublicationState.State.FAILED) {
                System.out.print("Video failed uploading because: ");
                System.out.println(pubState.getDescription());
                System.out.print("For help visit: ");
                System.out.println(pubState.getHelpUrl());
            }
        }

        if(videoEntry.getEditLink() != null) {
            System.out.println("Video is editable by current user.");
        }

        if(detailed) {

            YouTubeMediaGroup mediaGroup = videoEntry.getMediaGroup();

            System.out.println("Uploaded by: " + mediaGroup.getUploader());

            System.out.println("Video ID: " + mediaGroup.getVideoId());
            System.out.println("Description: " +
                    mediaGroup.getDescription().getPlainTextContent());


            YtStatistics stats = videoEntry.getStatistics();
            if(stats != null ) {
                System.out.println("View count: " + stats.getViewCount());
            }
            System.out.println();



            System.out.println("\tMedia:");
            for(YouTubeMediaContent mediaContent : mediaGroup.getYouTubeContents()) {
                System.out.println("\t\tMedia Location: "+ mediaContent.getUrl());
                System.out.println("\t\tMedia Type: "+ mediaContent.getType());
                System.out.println("\t\tDuration: " + mediaContent.getDuration());
                System.out.println();
            }

            for(YouTubeMediaRating mediaRating : mediaGroup.getYouTubeRatings()) {
                System.out.println("Video restricted in the following countries: " +
                        mediaRating.getCountries().toString());
            }
        }
    }
}
new YouTubeDataFetch().commentYouTubeFeeds();
*/
