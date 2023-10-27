# SpaceCraftDemo
ViewModel: Acts as an intermediary between the View and the UseCase. It exposes the SpaceCraftData as LiveData or StateFlow for the View to observe. It receives requests from the View and communicates with the usecase and usecase interact with the repository to fetch the data.

Repository: Manages the data operations. It abstracts the data source (API) and provides a clean API for data access. In this case, it interacts with the Retrofit client to make API calls and fetch SpaceCraft Data.

UseCase : It interacts with the repository to fetch the data and it is a abstarct layer between viewmodel and repository.

Retrofit: A type-safe HTTP client for making network requests. It handles the network operations, such as making HTTP requests, receiving responses, and parsing JSON. It communicates with the API to fetch SpaceCraft Data.

API: The backend API that provides the SpaceCraft Data. It receives requests from Retrofit and returns the SpaceCraft Data as a response.

The flow of data starts from the View, which triggers a request for SpaceCraft Data in the ViewModel. The ViewModel communicates with the usecase according to the usecase, and that interacts with the repository, which uses Retrofit to make an API call to fetch the data from the API. The API returns the Space Craft  data as a response, which is then passed back to the Repository and then to usecase. The UseCase provides the data to the ViewModel, which updates its state and exposes the data to the View. Finally, the View displays the data to the user.

