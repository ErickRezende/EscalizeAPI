package com.erickrezende.musicsapi.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class UserService {

    private final UserRepository repository;

    // Create
    private User create(User user) {
        return repository.save(user);
    }

    // Read
    public List<User> getAllUsers(){
        return repository.findAll();
    }
    
    public User getUser(String id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "User not found on db"
            ));
    }

    // Update
    public User update(String id, User updatedUser){
        User existingUser = getUser(id);
        
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setAdmin(updatedUser.getAdmin());
        existingUser.setRoles(updatedUser.getRoles());

        return repository.save(existingUser);
    }

    // Delete 
    public void delete(String id) {
        repository.delete(getUser(id));
    }

    // Sign Up

    public void signup(String name, String email, String password, String admin, String roles) {
        // TODO: Receber os dados e cadastrar como novo usuário

        
        /*
            const { name, email, password, admin, roles } = req.body;

            try {
                
                const existing = await UserModel.findOne({ email });
                if (existing) return res.status(400).json({ message: 'Email já cadastrado' });

                const newUser = new UserModel({ name, email, password, admin, roles });
                await newUser.save();

                // gera token
                const token = jwt.sign({ id: newUser._id }, process.env.JWT_SECRET, {
                expiresIn: '7d',
                });

                res.json({
                token,
                user: { name: newUser.name, email: newUser.email }
                });

            } catch (err) {
                console.error(err);
                res.status(500).json({ message: 'Erro interno ao criar usuário' });
            }
        */
    }

    // Login
    public void login(String email, String password) {
            // TODO: Receber email e senha, validar e gerar um token


            /*
                const { email, password } = req.body;

                const user = await UserModel.findOne({ email });

                if (!user || !(await user.comparePassword(password))) {
                    return res.status(401).json({ message: 'Credenciais inválidas' });
                }

                const token = jwt.sign({ id: user._id }, process.env.JWT_SECRET, {
                    expiresIn: '7d',
                })

                res.json({ token, user: { name: user.name, email: user.email } })
            */
    }
}
