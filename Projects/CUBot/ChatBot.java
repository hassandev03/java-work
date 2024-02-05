import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.json.JSONObject;

public class ChatBot {
    public static void main(String[] args) {
        new ChatFrame();
    }
}

class ChatFrame extends JFrame implements ActionListener {
    private JTextArea responseBlock = new JTextArea();
    private JTextField txtBar = new JTextField();
    private JButton enter = new JButton();
    private JLabel botName = new JLabel("CUBot");
    private ImageIcon botIcon = new ImageIcon(".\\Icons\\cubot.jpg");
    private ImageIcon buttonIcon = new ImageIcon(".\\Icons\\button.png");
    //                                                  top, left, bottom, right
    private EmptyBorder blockBorder = new EmptyBorder(20, 20, 40, 20);
    private JScrollPane scrollPane = new JScrollPane(responseBlock);
    private JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
    private JFileChooser fileChooser = new JFileChooser();
    
    // non-gui components
    private String queryText;
    private Random random = new Random();
    private Timer welcomeTimer, exitTimer;
    private TimerTask greetings, byeMessage;
    private String[] saveResponse = new String[1];

    ChatFrame() {
        // panel properties
        setIconImage(botIcon.getImage());
        setTitle("CUBot");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setSize(640, 680);
        setResizable(false);
        getContentPane().setBackground(new Color(0x0D1627));

        // bot name
        botName.setFont(new Font("Copperplate Gothic", Font.BOLD, 50));
        botName.setForeground(new Color(0xBCD4FF));
        botName.setBounds(240, 20, getWidth(), 70);
        add(botName);

        // reponse area
        responseBlock.setBounds(35, 110, 550, 400);
        responseBlock.setBackground(new Color(0x1E283C));
        responseBlock.setFont(new Font("DM Sans", Font.PLAIN, 18));
        responseBlock.setForeground(new Color(0x9CBFBC));
        responseBlock.setBorder(blockBorder);
        responseBlock.setWrapStyleWord(true);
        responseBlock.setLineWrap(true);
        responseBlock.setEditable(false);
        add(responseBlock);

        // text bar
        txtBar.setBounds(40, 535, 480, 35);
        txtBar.setBackground(new Color(0x61778E));
        txtBar.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        txtBar.setForeground(new Color(0x10161D));
        txtBar.addActionListener(this);
        add(txtBar);

        // button
        enter.setFocusable(false);
        enter.setBounds(530, 535, 50, 35);
        enter.setIcon(buttonIcon);
        enter.setBackground(new Color(0x212B3B));
        enter.addActionListener(this);
        add(enter);

        // scrollbar (JScrollBar) using scrollpane (JScrollPane)
        scrollPane.setBounds(35, 110, 550, 400);
        scrollPane.setViewportView(responseBlock);
        verticalScrollBar.setBackground(new Color(0x1E283C));
        verticalScrollBar.setForeground(new Color(0x3C517A));
        verticalScrollBar.setUnitIncrement(16);
        getContentPane().add(scrollPane);

        // timer to display greetings to user
        welcomeTimer = new Timer();
        greetings = new TimerTask() {
            @Override
            public void run() {
                // show a welcome response
                welcome();
            }
        };
        welcomeTimer.schedule(greetings, 500);
    }

    //               get text from text bar
    public void actionPerformed(ActionEvent ev) {
        queryText = getQuery(ev);
        userResponse(queryText);
        textRecognizer(queryText);
    }

    //                      welcome responses at start of program
    private void welcome() {
        String[] startResponses = new String[16];

        String fileName = ".\\Responses\\start.txt";
        readData(fileName, startResponses);
        
        int startIndex = random.nextInt(startResponses.length);
        saveResponse[0] = startResponses[startIndex];
        botResponse(startResponses[startIndex]);
    }

    private void textRecognizer(String queryText) {
        // string array for a message must be displayed on some requests
        String[] everyTime = {
                "Happy to assist", "Sure thing", "I'm here for you", "Roger that", "Right away",
                "Count on me", "By all means", "No problem at all", "I've got you covered",
                "Without a doubt", "Absolutely, let's do it", "Consider it done",
                "You can rely on me", "Certainly, I'll handle it"
        };
        int randomEvery = random.nextInt(everyTime.length);

        // if user wants to open a text file
        if (queryText.contains("open") && (queryText.contains("text") && queryText.contains("file"))) {
            botResponse(everyTime[randomEvery]);
            textFileOpener();
        }

        // if user wants to open a file
        else if (queryText.contains("open") || queryText.contains("run") || queryText.contains("launch")){
            botResponse(everyTime[randomEvery]);
            applicationOpener(queryText);
        }

        // if user asks bot, how is it
        else if (queryText.contains("how are you")) {
            howAreYou();
        }

        // if user wants to exit
        else if (queryText.contains("goodbye") || queryText.contains("bye") || queryText.contains("exit") || queryText.contains("allah hafiz")) {
            bye();
        }

        // if user wants to check weather
        else if (queryText.contains("weather")) {
            botResponse(everyTime[randomEvery]);
            weather();
        }

        // if user wants to take screenshot
        else if ((queryText.contains("take") || queryText.contains("capture"))
                && ((queryText.contains("screen") || queryText.contains("snap")) && queryText.contains("shot"))) {
            botResponse(everyTime[randomEvery]);
            takeScreenShot();
        }

        // if user wants a joke
        else if (queryText.contains("joke")) {
            botResponse(everyTime[randomEvery]);
            joke();
        }

        // if user asks the bot about itself
        else if (((queryText.contains("your") && queryText.contains("name")) || (queryText.contains("your") && queryText.contains("introduction")))
         || (((queryText.contains("about") || queryText.contains("introduce")) && queryText.contains("yourself")) || (queryText.contains("who") && queryText.contains("you")))
         || queryText.endsWith("what are you?") || queryText.endsWith("what are you")) {
            botIntroduction();
        }

        // if user asks about age of the bot
        else if (((queryText.contains("what") && queryText.contains("age")) || (queryText.contains("how") && (queryText.contains("old") || (queryText.contains("years") && queryText.contains("old")))))
                && (queryText.contains("your") || queryText.contains("you")) && (queryText.contains("is") || queryText.contains("are"))) {
            age();

        // if users wants to calculate their bmi
        } else if (queryText.contains("bmi") && (queryText.contains("calculate") || queryText.contains("check"))) {
            botResponse(everyTime[randomEvery]);
            BMI();
            

        // if user wants to save a response
        } else if ((queryText.contains("save") || queryText.contains("store")) && (queryText.contains("response") || queryText.contains("info"))){
            botResponse(everyTime[randomEvery]);
            saveResponse(saveResponse);
        }

        // handle any other query
        else {
            requestProcessing(queryText);
        }
    }

    //          save user response
    private void saveResponse(String[] saveResponse) {
        fileChooser.setDialogTitle("Choose File Save Location");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text File", "txt"));

        // returns an integer value; 0 for completed/approved
        int result = fileChooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            try (PrintWriter writer = new PrintWriter(fileChooser.getSelectedFile())) {
                String time = currentTime();
                // time formatting
                time = time.substring(0, 2) + ":" + time.substring(2, 4)
                         + ":" + time.substring(4, 6) + " " + time.substring(6, 8);
                
                writer.print(saveResponse[0] + "\n" + "Saved at: " + time);
                botResponse("File has successfully been saved at: " + fileChooser.getSelectedFile().getParent());
            } catch (IOException e) {
                botResponse("Unfortunately! I wasn't able to store at this location.");
            }
        }
        else {
            botResponse("You canceled the save operation");
        }
        
    }

    //                  open text file method
    private void textFileOpener() {
        fileChooser.setDialogTitle("Select Text File");

        // only text filter
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text File", "txt"));
        int result = fileChooser.showOpenDialog(fileChooser);

        // check if user opened file or not
        if (result == JFileChooser.APPROVE_OPTION) {
            // get the current file
            File file = fileChooser.getSelectedFile();
            try {
                String fileContents = "Contents of the file are:\n" + Files.readString(file.toPath());
                saveResponse[0] = fileContents;
                botResponse(fileContents);

            } catch (IOException e) {
                botResponse("Unfortunately! An error occured while opening the file");
            }
        }
        else {
            botResponse("You didn't select a file!");
        }
    }


    //                              how are you responses
    private void howAreYou() {
        String[] howAreYouResponses = new String[18];

        String fileName = ".\\Responses\\howAreYou.txt";
        readData(fileName, howAreYouResponses);

        int responseIndex = random.nextInt(howAreYouResponses.length);
        saveResponse[0] = howAreYouResponses[responseIndex];
        botResponse(howAreYouResponses[responseIndex]);
    }

    //                                  bye responses
    private void bye() {
        String[] byes = new String[15];

        String fileName = ".\\Responses\\bye.txt";
        readData(fileName, byes);

        int byeIndex = random.nextInt(byes.length);
        botResponse(byes[byeIndex]);

        // timer for exit
        exitTimer = new Timer();
        byeMessage = new TimerTask() {
            @Override
            public void run() {
                System.exit(0);
            }
        };
        exitTimer.schedule(byeMessage, 500);
    }

    //                                      joke reponses
    private void joke() {
        String[] jokes = new String[29];

        String fileName = ".\\Responses\\joke.txt";
        readData(fileName, jokes);

        int jokeIndex = random.nextInt(jokes.length);
        saveResponse[0] = jokes[jokeIndex];
        botResponse(jokes[jokeIndex]);
    }

    //                                  bot's introduction
    private void botIntroduction() {
        String[] intros = new String[13];

        String fileName = ".\\Responses\\intro.txt";
        readData(fileName, intros);

        int nameIndex = random.nextInt(intros.length);
        saveResponse[0] = intros[nameIndex];
        botResponse(intros[nameIndex]);
    }

    //                                      age responses
    private void age() {
        String[] ages = new String[16];

        String fileName = ".\\Responses\\age.txt";
        readData(fileName, ages);
        
        int ageIndex = random.nextInt(ages.length);
        saveResponse[0] = ages[ageIndex];
        botResponse(ages[ageIndex]);
    }

    //                              open applications
    private void applicationOpener(String queryText2) {
        boolean run = true;
        ProcessBuilder application = new ProcessBuilder();
        Process process;
        String appName = "";
        if (queryText2.contains("notepad")) {
            appName = "Notepad";
            application.command("notepad.exe");
        } 
        else if (queryText2.contains("file explorer")) {
            appName = "File Explorer";
            if (queryText2.contains("search")) {
                int index = queryText2.indexOf("search");
                String fileName = queryText2.substring(index + 7);
                application.command("explorer.exe", "search-ms:query= " + fileName);
            } else {
                application.command("explorer.exe");
            }
        } 
        else if (queryText2.contains("chrome") || queryText2.contains("browser")) {
            appName = "Google Chrome";
            String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
            if (queryText2.contains("search")) {
                int index = queryText2.indexOf("search");
                String searchQuery = "https://www.google.com/search?q=" + queryText2.substring(index + 7);
                application.command(chromePath, searchQuery);
            } else {
                application.command(chromePath);
            }
        } 
        else if (queryText2.contains("calculator")) {
            appName = "Calculator";
            application.command("calc.exe");
        } 
        else if (queryText2.contains("setting")) {
            appName = "Settings";
            application.command("cmd", "/c", "start", "ms-settings:");
        } 
        else if (queryText2.contains("clock")) {
            appName = "Clock";
            application.command("cmd", "/c", "start", "ms-clock:");
        } 
        else if (queryText2.contains("paint")) {
            appName = "MS Paint";
            application.command("mspaint.exe");
        } 
        else if (queryText2.contains("word")) {
            appName = "Microsoft Word";
            application.command("C:\\Program Files\\Microsoft Office\\root\\Office16\\WINWORD.EXE");
        } 
        else if (queryText2.contains("powerpoint")) {
            appName = "Microsoft PowerPoint";
            application.command("C:\\Program Files\\Microsoft Office\\root\\Office16\\POWERPNT.EXE");
        } 
        else if (queryText2.contains("excel")) {
            appName = "Microsoft Excel";
            application.command("C:\\Program Files\\Microsoft Office\\root\\Office16\\EXCEL.EXE");
        } 
        else if (queryText2.contains("access")) {
            appName = "Microsoft Access";
            application.command("C:\\Program Files\\Microsoft Office\\root\\Office16\\MSACCESS.EXE");
        } 
        else if (queryText2.contains("skype")) {
            appName = "Skype";
            application.command("C:\\Program Files\\Microsoft Office\\root\\Office16\\lync.exe");
        } 
        else if (queryText2.contains("one note")) {
            appName = "Microsoft One Note";
            application.command("C:\\Program Files\\Microsoft Office\\root\\Office16\\ONENOTE.EXE");
        } 
        else if (queryText2.contains("publisher")) {
            appName = "Microsoft Publisher";
            application.command("C:\\Program Files\\Microsoft Office\\root\\Office16\\MSPUB.EXE");
        } 
        else if (queryText2.contains("outlook")) {
            appName = "Microsoft Outlook";
            application.command("C:\\Program Files\\Microsoft Office\\root\\Office16\\OUTLOOK.EXE");
        } 
        else if (queryText2.contains("camera")) {
            appName = "Camera";
            application.command("cmd", "/c", "start", "microsoft.windows.camera:");
        } 
        else if (queryText2.contains("edge")) {
            appName = "Microsoft Edge";
            application.command("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
        } 
        else if (queryText2.contains("cmd") || (queryText2.contains("command") && queryText2.contains("prompt")) ) {
            appName = "Command Prompt";
            application.command("cmd", "/c", "start");
        } 
        else if (queryText2.contains("store")) {
            appName = "Microsoft Store";
            application.command("cmd", "/c", "start", "ms-windows-store:");
        }
        else if (queryText2.contains("photo") && queryText2.contains("shop")) {
            appName = "Adobe Photoshop CC";
            application.command("C:\\Program Files\\Adobe\\Adobe Photoshop 2020\\Photoshop.exe");
        }
        else if (queryText2.contains("download") && queryText2.contains("manager")) {
            appName = "Internet Download Manager";
            application.command("C:\\Program Files (x86)\\Internet Download Manager\\IDMan.exe");
        }
        else if (queryText2.contains("photos") || (queryText2.contains("photo") && queryText2.contains("viewer"))) {
            appName = "Microsoft Photos";
            application.command("cmd", "/c", "start", "ms-photos:");
        }
        else if (queryText2.contains("snipping") && queryText2.contains("tool")) {
            appName = "Snipping Tool";
            application.command("cmd", "/c", "start", "snippingtool");
        }
        else if (queryText2.contains("video") && queryText2.contains("player")) {
            appName = "VLC Video Player";
            application.command("C:\\Program Files\\VideoLAN\\VLC\\vlc.exe");
        }
        else {
            botResponse("Either I don't have Access to the Application or you mispelled Application Name!");
            run = false;
        }
        if (run) {
            botResponse("Launching " + appName);
            try {
                process = application.start();
            } catch (IOException e) {
                responseBlock.append("CUBot:    " + "Sorry! I was unable to open the application" + "\n");
            }
        }
    }

    //                              screenshot method
    private void takeScreenShot() {
        try {
            // robot class used to perform automatic operations or simulate operations
            Robot screenCaptureRobot = new Robot();
            // create a rectangle screen object that contains the dimensions
            Rectangle rectangleScreen = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            // capture the screen
            BufferedImage screenCapture = screenCaptureRobot.createScreenCapture(rectangleScreen);
            // destination to store screenshot
            String destination = "Screenshots";
            // save to directory and check existence
            File directory = new File(destination);
            if (!directory.exists()) {
                directory.mkdir();
            }

            // create and save screenshot
            String screenShotTime = currentTime();
            File screenShotFile = new File(directory + "\\" + screenShotTime + "_screenshot.png");
            ImageIO.write(screenCapture, "png", screenShotFile);

            // show response of successful screenshot saving
            botResponse("ScreenShot has been saved to: " + screenShotFile.getAbsolutePath());

        } catch (AWTException | IOException e) {
            botResponse("Unfortunately! I wasn't able to take ScreenShot.");
        }
    }

    //                                  get current time
    private String currentTime() {
        // take current time
        LocalTime time = LocalTime.now();

        // define custom format pattern
        DateTimeFormatter formatPattern = DateTimeFormatter.ofPattern("hhmmssa");

        // format the time according to reqired pattern
        String formattedTime = time.format(formatPattern);
        // retturn formatted time
        return formattedTime;
    }

    //                                      weather module
    private void weather() {
        StringBuilder weatherResponse = new StringBuilder();
        String city = JOptionPane.showInputDialog(null, "Enter City Name: ", "City Name",
                JOptionPane.QUESTION_MESSAGE);
        String apiKey = "a1fd3a926abf969bb63933418ad4dfdc";
        String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey
                + "&units=metric";

        try {
            URL url = new URI(apiUrl).toURL();
            // open connection for weather url
            HttpURLConnection weatherConnection = (HttpURLConnection) url.openConnection();
            // receive data ; GET request method gets data
            weatherConnection.setRequestMethod("GET");

            // read the message file received from the weather api
            BufferedReader weatherReader = new BufferedReader(
                    new InputStreamReader(weatherConnection.getInputStream()));
            String line = "";

            // store the respone line by line in response object;
            while ((line = weatherReader.readLine()) != null) {
                weatherResponse.append(line);
            }
            weatherReader.close();
            weatherConnection.disconnect();
        } catch (IOException | URISyntaxException e) {
            botResponse("An error occurred or You may have mispelled City Name.");
        }
        JSONObject jsonObject = new JSONObject(weatherResponse.toString());
        String weatherMain = jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
        String description = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
        double temp = jsonObject.getJSONObject("main").getDouble("temp");
        double feelsLike = jsonObject.getJSONObject("main").getDouble("feels_like");
        double tempMin = jsonObject.getJSONObject("main").getDouble("temp_min");
        double tempMax = jsonObject.getJSONObject("main").getDouble("temp_max");
        int pressure = jsonObject.getJSONObject("main").getInt("pressure");
        int humidity = jsonObject.getJSONObject("main").getInt("humidity");
        double windSpeed = jsonObject.getJSONObject("wind").getDouble("speed");
        String cityName = jsonObject.getString("name");

        String weatherInfo = "Weather Details for " + cityName + " are:" + "\n" +
                "                Weather: " + weatherMain + " - " + description + "\n" +
                "                Temperature: " + temp + "°C" + "\n" +
                "                Feels Like: " + feelsLike + "°C" + "\n" +
                "                Min Temperature: " + tempMin + "°C" + "\n" +
                "                Max Temperature: " + tempMax + "°C" + "\n" +
                "                Atmospheric Pressure: " + pressure + " hPa" + "\n" +
                "                Humidity: " + humidity + "%" + "\n" +
                "                Wind Speed: " + windSpeed + " m/s";
        saveResponse[0] = weatherInfo;
        botResponse(weatherInfo);
    }

    //                              process requests
    private void requestProcessing(String queryText2) {
        String apiUrl = "https://api.openai.com/v1/chat/completions";
        String apiKey = "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"; // Replace with your actual API key
        String apiModel = "gpt-3.5-turbo-1106";
        StringBuilder response = new StringBuilder();

        try {
            URL urlObj = new URI(apiUrl).toURL();
            HttpURLConnection requestConnection = (HttpURLConnection) urlObj.openConnection();
            // send request along with some data or information
            requestConnection.setRequestMethod("POST");
            // Authorization as Bearer so that API will give access to its key
            requestConnection.setRequestProperty("Authorization", "Bearer " + apiKey);
            // request type will be JSON
            requestConnection.setRequestProperty("Content-Type", "application/json");

            String requestBody = "{\"model\": \"" + apiModel + "\", \"messages\": [{\"role\": \"user\", \"content\": \""
                    + queryText2 + "\"}]}";

            // prepare to send request (data) to url
            requestConnection.setDoOutput(true);

            // create a such writer object that'll write the request that will be sent as a request
            // .getOutputStream will get the path where it should be written
            OutputStreamWriter requestWriter = new OutputStreamWriter(requestConnection.getOutputStream());
            // write the request body (JSON Object) to the output stream (sending path of request)
            requestWriter.write(requestBody);
            // immediately send the request body
            requestWriter.flush();

            // read the message coming from the api
            // .getInputStream gets access to the data that is coming back from the api (server)
            // InputStreamReader will assist in reading the incoming data (reponse from api);
            //    >> it's like a translator that understands server's language and help us
            //       understand the message from server
            BufferedReader messageReader = new BufferedReader(
                    new InputStreamReader(requestConnection.getInputStream()));

            // create string object that'll store each line while reading message
            String line;

            // loop to read line by line and store reponse in string builder object
            while ((line = messageReader.readLine()) != null) {
                response.append(line);
            }
            messageReader.close();
        } catch (IOException | URISyntaxException e) {
            botResponse("Unfortunately! I wasn't able to process your request.");
        }
        // Create a JSON Object to format the received response
        JSONObject responseObject = new JSONObject(response.toString());
        responseObject = responseObject.getJSONArray("choices").getJSONObject(0).getJSONObject("message");
        String outputMessage = responseObject.getString("content");
        saveResponse[0] = outputMessage;
        botResponse(outputMessage);
    }

    //                                  calculate BMI
    private void BMI() {
        float inches, weightInKg, heightInMeters, bmi;
        final float METERS_PER_INCH = 0.0254f;

        weightInKg = Float.parseFloat(JOptionPane.showInputDialog(null,
                "Enter you weight (in Kgs): ", "Your Weight", JOptionPane.QUESTION_MESSAGE));

        inches = Float.parseFloat(JOptionPane.showInputDialog(null,
                "Enter Height (in Inches): ", "Your Height", JOptionPane.QUESTION_MESSAGE));

        heightInMeters = inches * METERS_PER_INCH;
        bmi = weightInKg / (heightInMeters * heightInMeters);

        String bmiText = "Your BMI is: %f".replace("%f", Float.toString(bmi));
        if (bmi < 18.5) {
            bmiText += "\nYou're Underweight";
        } else if (bmi < 20) {
            bmiText += "\nYou're Normal";
        } else if (bmi < 30) {
            bmiText += "\nYou're Overweight";
        } else {
            bmiText += "\nYou're Obese";
        }
        saveResponse[0] = bmiText;
        botResponse(bmiText);
    }

    //              reading the data
    private void readData(String fileName, String[] responses) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            byte index = 0;
            while (reader.ready()) {
                responses[index] = reader.readLine();
                index++;
            }
        } catch (IOException e) {
            botResponse("An Error occurred while generating the response");
        }
    }
    
    //                          show bot reponse on screen
    private void botResponse(String returnedResult) {
        if (returnedResult != null && !returnedResult.isEmpty()) {
            responseBlock.append("CUBot:    " + returnedResult + "\n");
        }
    }

    //                          show user response on screen
    private void userResponse(String userQuery) {
        responseBlock.append("You:    " + userQuery + "\n");
        txtBar.setText("");
    }

    //                          get the user response from window
    private String getQuery(ActionEvent ev) {
        if (ev.getSource() == enter || ev.getSource() == txtBar) {
            return txtBar.getText().toLowerCase().trim();
        } else {
            return "";
        }
    }
}