package kh.com.vireak.developer.basic.myapplicationbackup.feature.userApi

import android.util.Patterns
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import kh.com.vireak.developer.basic.myapplicationbackup.R
import kh.com.vireak.developer.basic.myapplicationbackup.model2.BaseUiState
import kh.com.vireak.developer.basic.myapplicationbackup.model2.response.UserApiResponse
import kh.com.vireak.developer.basic.myapplicationbackup.ui.theme.MyApplicationBackupTheme
import kh.com.vireak.developer.basic.myapplicationbackup.ui.theme.randomColor
import kh.com.vireak.developer.basic.myapplicationbackup.util.LoadingUtil



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenUserApi(
    userApiVM: UserApiVm = viewModel(),
    onBack: () -> Unit = {}

){

    var showFullscreenDialog by remember { mutableStateOf(false) }
    val userUiState by userApiVM.userListUiState.collectAsStateWithLifecycle()
    var selectedUser by remember { mutableStateOf<UserApiResponse?>(null) }

    LaunchedEffect(userUiState){
        when (val state = userUiState){

            is BaseUiState.Loading -> LoadingUtil.showLoading()

            is BaseUiState.Success -> LoadingUtil.hideLoading()

            is BaseUiState.Error -> {
                LoadingUtil.hideLoading()
                println(" ==> ${state.message}")
            }
            else -> {}
        }

    }

    LaunchedEffect(Unit) {
        userApiVM.getUserList()
    }

    LaunchedEffect(Unit) {
        userApiVM.updateUser(
            id = 1 ,
            name = "vireaknotupdate",
            email = "vireak@gmail.com"
        )
    }

//    LaunchedEffect(Unit){
//        userApiVM.createUser(
//            name = "Doaks",
//            email = "jamesdoaks@gmail.com"
//        )
//    }


    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_backward_arrow),
                            contentDescription = "Back",
                        )
                    }

                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        text = "User API"
                    )
                },
                actions = {
                    IconButton(
                        onClick = {
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_calender),
                            contentDescription = ""
                        )
                    }
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_menu),
                            contentDescription = ""
                        )
                    }

                }

            )

        },
        bottomBar = {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                onClick = {
                    showFullscreenDialog = true
                }
            ) {
                Text(text = "Create User")
            }
        }

    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 6.dp)
                    .height(140.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_user),
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Users",
                        fontSize = 24.sp
                    )

                    Text(
                        text = "Manage your user directory",
                        fontSize = 12.sp
                    )
                }
            }

            when (val state = userUiState) {
                is BaseUiState.None -> {
                    Text(text = "Ready to Load Users")
                }

                is BaseUiState.Loading -> {
                }

                is BaseUiState.Success -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(state.data) { user ->
                            UserItem(
                                user = user,
                                onEditClick = {
                                    selectedUser = user
                                    println("==> tapped user ${user.id}")
                                }
                            )
                        }
                    }
                }

                is BaseUiState.Error -> {
                    Text(text = state.message)
                }

                is BaseUiState.ErrorWithException -> {
                    Text(text = "Something went wrong")
                }
            }
        }
        if (showFullscreenDialog) {

            Dialog(
                onDismissRequest = {
                    showFullscreenDialog = false
                },

                properties = DialogProperties(
                    usePlatformDefaultWidth = false
                )


            ) {
                CreateUserScreen(
                    onDismiss = {
                        showFullscreenDialog = false
                    }
                )
            }
        }

        selectedUser?.let { user ->
            EditUserSheet(
                user = user,
                onSave = { name, email ->
                    userApiVM.updateUser(
                        name = name,
                        email = email,
                        id = user.id
                    )
                    selectedUser = null

                },
                onDismiss = {
                    selectedUser = null
                }
            )

        }


    }
}

@Composable
fun UserItem(
    user: UserApiResponse,
    onEditClick: () -> Unit
) {
    val profileLetter = user.name
        .firstOrNull()
        ?.uppercase() ?: "?"

    val avatarColors = listOf(
        Color(0xFFE57373), // Red
        Color(0xFF64B5F6), // Blue
        Color(0xFF81C784), // Green
        Color(0xFFFFB74D), // Orange
        Color(0xFFBA68C8), // Purple
        Color(0xFF4DB6AC)  // Teal
    )

    val avatarColor = avatarColors[
        user.id.mod(avatarColors.size)
    ]

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        ListItem(
            headlineContent = {
                Text(text = user.name)
            },
            supportingContent = {
                Text(text = user.email)
            },
            leadingContent = {
                Row(
                    modifier = Modifier.padding(2.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .size(60.dp)
                            .clip(shape = RoundedCornerShape(32.dp))
                            .background(avatarColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = profileLetter,
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White
                        )
                    }

                }
            },
            trailingContent = {
                IconButton(
                    onClick = onEditClick
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_edit),
                        contentDescription = ""
                    )
                }
            }
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditUserSheet(
    user: UserApiResponse,
    onSave: (name: String, email: String) -> Unit,
    onDismiss: () -> Unit
){
    var name by remember { mutableStateOf(user.name) }
    var email by remember { mutableStateOf(user.email) }

    var nameError by remember{ mutableStateOf<String?>(null) }
    var emailError by remember{ mutableStateOf<String?>(null) }

    ModalBottomSheet(
        onDismissRequest = onDismiss
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            Text("Edit User", style = MaterialTheme.typography.headlineSmall)

            OutlinedTextField(
                value = name,
                onValueChange = {
                    name = it
                    nameError = null // clear the error when the user starts typing
                },
                label = {
                    Text("FullName")
                },
                isError = nameError != null,  // red outline
                supportingText = { nameError?.let { Text(it) } }, // message under the field
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    emailError = null
                },
                isError = emailError != null,
                supportingText = {
                    emailError?.let { Text(it) }
                },
                label = {
                    Text("Email Address")
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    val cleanName = name.trim()
                    val cleanEmail = email.trim()

                    nameError = if (cleanName.isBlank()) "Name cannot be blank" else null
                    emailError = when {
                        cleanEmail.isBlank() -> "Email cannot be blank"
                        !Patterns.EMAIL_ADDRESS.matcher(cleanEmail).matches() -> "Please enter a valid email"
                        else -> null
                    }

                    if (nameError == null && emailError == null) {
                        onSave(cleanName, cleanEmail)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Save Change")
            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun ScreenUserApiPreview(){
    MyApplicationBackupTheme() {
        ScreenUserApi()
    }
}