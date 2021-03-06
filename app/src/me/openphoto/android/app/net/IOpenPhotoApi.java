
package me.openphoto.android.app.net;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import me.openphoto.android.app.net.HttpEntityWithProgress.ProgressListener;
import oauth.signpost.OAuthConsumer;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

public interface IOpenPhotoApi {

    /**
     * Sets the OAuthConsumer when the calls with the server need to be
     * authenticated.
     * 
     * @param oAuthConsumer
     */
    void setOAuthConsumer(OAuthConsumer oAuthConsumer);

    /**
     * @return tags which are used on the server
     * @throws ClientProtocolException
     * @throws IOException
     * @throws IllegalStateException
     * @throws JSONException
     */
    TagsResponse getTags() throws ClientProtocolException, IOException, IllegalStateException,
            JSONException;

    /**
     * Retrieve a single photo.
     * 
     * @param photoId id of the photo
     * @param returnSize which sizes should be returned
     * @return the photo
     * @throws IOException
     * @throws ClientProtocolException
     * @throws JSONException
     * @throws IllegalStateException
     */
    PhotoResponse getPhoto(String photoId, ReturnSizes returnSize) throws ClientProtocolException,
            IOException, IllegalStateException, JSONException;

    /**
     * Will return the URL to which the user has to start the OAuth
     * authorization process.
     * 
     * @param name Name of the app for which authorization is requested
     * @param callback Where the user should be forwarded after authorizing the
     *            app.
     * @return Url to which the user should be pointed in a WebView.
     */
    String getOAuthUrl(String name, String callback);

    /**
     * Get photos.
     * 
     * @return the photos
     * @throws ClientProtocolException
     * @throws IOException
     * @throws IllegalStateException
     * @throws JSONException
     */
    PhotosResponse getPhotos()
            throws ClientProtocolException, IllegalStateException, IOException, JSONException;

    /**
     * Get photos.
     * 
     * @param resize which sizes should be returned
     * @return the photos
     * @throws ClientProtocolException
     * @throws IOException
     * @throws IllegalStateException
     * @throws JSONException
     */
    PhotosResponse getPhotos(ReturnSizes resize)
            throws ClientProtocolException, IllegalStateException, IOException, JSONException;

    /**
     * Get photos.
     * 
     * @param resize which sizes should be returned
     * @param paging paging information
     * @return the photos
     * @throws ClientProtocolException
     * @throws IOException
     * @throws IllegalStateException
     * @throws JSONException
     */
    PhotosResponse getPhotos(ReturnSizes resize, Paging paging)
            throws ClientProtocolException, IllegalStateException, IOException, JSONException;

    /**
     * Get photos.
     * 
     * @param resize which sizes should be returned
     * @param tags filter potos by these tags
     * @return the photos
     * @throws ClientProtocolException
     * @throws IOException
     * @throws IllegalStateException
     * @throws JSONException
     */
    PhotosResponse getPhotos(ReturnSizes resize, Collection<String> tags)
            throws ClientProtocolException, IllegalStateException, IOException, JSONException;

    /**
     * Get photos.
     * 
     * @param resize which sizes should be returned
     * @param tags filter potos by these tags
     * @param pageing page and pageSize to be retrieved
     * @return the photos
     * @throws ClientProtocolException
     * @throws IOException
     * @throws IllegalStateException
     * @throws JSONException
     */
    PhotosResponse getPhotos(ReturnSizes resize, Collection<String> tags, Paging paging)
            throws ClientProtocolException, IOException, IllegalStateException, JSONException;

    /**
     * Upload a picture.
     * 
     * @param imageFile the image file
     * @param metaData MetaData which define title, ... of the photo
     * @param progressListener Listener that will be called on progress
     * @return The response with which contains info about the uploaded photo
     * @throws IOException
     * @throws ClientProtocolException
     * @throws JSONException
     * @throws IllegalStateException
     */
    UploadResponse uploadPhoto(File imageFile, UploadMetaData metaData,
            ProgressListener progressListener)
            throws ClientProtocolException, IOException, IllegalStateException, JSONException;
}
